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
browser.get("https://www.hfairport.com/Reach/index.aspx?page=1")

result = []
flightno = []
flightct = []
deptime = []
arrtime = []

def get_products():
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, '#container > section > article > div.Contactcss > div.tbody > table')))
    html = browser.page_source
    # 创建PyQuery对象
    doc = pq(html)
    # print(html)
    items = doc('#container > section > article > div.Contactcss > div.tbody > table > tbody').items()
    for item in items:
        product = {
            'flight_no': item.find('td:nth-child(3)').text().split(' '),
            'flight_ct': item.find('td:nth-child(1)').text().split(' '),
            'dep_time':item.find('td:nth-child(4)').text().split(' '),
            'arr_time':item.find('td:nth-child(5)').text().split(' '),
        }
    for i in range(1,len(product['flight_no'])):
        flightno.append(product['flight_no'][i])
        flightct.append(product['flight_ct'][i])
        deptime.append(product['dep_time'][i])
        arrtime.append(product['arr_time'][i])
    for i in range(1,len(flightno)):
        dtime1 = deptime[i][:2]
        dtime2 = deptime[i][2:4]
        dtime = dtime1 + ':' + dtime2
        atime1 = arrtime[i][:2]
        atime2 = arrtime[i][2:4]
        atime = atime1 + ':' + atime2
        fct = re.split('=|-', flightct[i])
        depct = fct[0]
        arrct = fct[1]
        myproduct = {
            'flight_no': flightno[i],
            'dep_ct': depct,
            'arr_ct': arrct,
            'dep_time': dtime,
            'arr_time': atime
        }
        result.append(myproduct)

# 翻页函数
def next_page(page_number):
    try:
        confirm_btn = wait.until(
            EC.element_to_be_clickable((By.CSS_SELECTOR, '#container > section > article > div.Pages > span > a.a_next'))
        )                                     # 等待确认按钮加载完成
        confirm_btn.click()                     # 确认点击翻页
        # 确认已翻到page_number页
        wait.until(EC.text_to_be_present_in_element(
            (By.CSS_SELECTOR, '#container > section > article > div.Pages > span > em > a.a_cur'), str(page_number))
        )
        get_products()
    # 若发生异常，重新调用自己
    except TimeoutException:
        next_page(page_number)

def main():
    get_products()
    total = 12
    for i in range(2,total+1):
        next_page(i)
    print(result)

    pf = pd.DataFrame(result)
    # 指定字段顺序
    column = ['flight_no', 'dep_ct', 'arr_ct', 'dep_time', 'arr_time']
    pf = pf[column]
    pf.to_excel('./airDataHefeiChufa.xls', index=False)

if __name__ == '__main__':
    main()

