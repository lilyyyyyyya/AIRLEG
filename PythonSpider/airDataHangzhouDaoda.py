from pyquery import PyQuery as pq
from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import re
import xlwt
import pandas as pd

path = "E:/chromedriver.exe"
options = webdriver.ChromeOptions()
# 设置为开发者模式，防止被各大网站识别出来使用Selenium
options.add_experimental_option('excludeSwitches',['enable-automation'])
# 创建WebDriver对象
browser = webdriver.Chrome(executable_path=path,options=options)
wait = WebDriverWait(browser,10)
browser.get("http://www.hzairport.com/flight/arrive.html")


result = []

def get_products():
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, 'body > div > div.inside_main > div > div.flight_cont > div.timetable_list')))
    html = browser.page_source
    # 创建PyQuery对象
    doc = pq(html)
    # print(html)
    items = doc('body > div > div.inside_main > div > div.flight_cont > div.timetable_list > .timetable_item').items()
    for item in items:
        if item.find('.end').text() == '到达':
            depactual = item.find('.time').text()[-5:]
        else:
            depactual = ''
        product = {
            'flight_no': item.find('.station').text()[:6],
            'dep_ct': item.find('.stop').text().split(' ')[0],
            'arr_ct': '杭州',
            'arr_scheduled': item.find('.time').text()[6:11],
            'arr_actual': depactual,
            'flight_state': item.find('.end').text()
        }
        result.append(product)

# 翻页函数
def next_page(page_number):
    try:
        confirm_btn = wait.until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, 'body > div.mainbody > div.inside_main > div > div.flight_cont > div.page > div > a:nth-child(13)'))
        )                                     # 等待确认按钮加载完成
        confirm_btn.click()                     # 确认点击翻页
        # 确认已翻到page_number页
        wait.until(EC.text_to_be_present_in_element(
            (By.CSS_SELECTOR, 'body > div.mainbody > div.inside_main > div > div.flight_cont > div.page > div > a.num.on'), str(page_number))
        )
        get_products()
    # 若发生异常，重新调用自己
    except TimeoutException:
        next_page(page_number)

def main():
    get_products()
    total = 26
    confirm_btn = wait.until(
        EC.element_to_be_clickable((By.CSS_SELECTOR, 'body > div.mainbody > div.inside_main > div > div.flight_cont > div.page > div > a:nth-child(12)'))
    )                                     # 等待确认按钮加载完成
    confirm_btn.click()                     # 确认点击翻页
    # 确认已翻到page_number页
    wait.until(EC.text_to_be_present_in_element(
        (By.CSS_SELECTOR, 'body > div.mainbody > div.inside_main > div > div.flight_cont > div.page > div > a.num.on'), str(2))
    )
    get_products()
    for i in range(3,total+1):
        next_page(i)
    print(result)

    pf = pd.DataFrame(result)
    # 指定字段顺序
    column = ['flight_no', 'dep_ct', 'arr_ct', 'arr_scheduled', 'arr_actual', 'flight_state']
    pf = pf[column]
    pf.to_excel('./airDataHangzhouDaoda.xls', index=False)

if __name__ == '__main__':
    main()