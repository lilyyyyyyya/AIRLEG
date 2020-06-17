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
browser.get("http://www.fuzhouairport.com.cn/hbxx/zhqjhhb/index.htm")

result = []
flightno = []
depct = []
arrct = []
deptime = []
arrtime = []

def get_products():
    wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, '#body_box > div.hangkongbiao > table')))
    html = browser.page_source
    # 创建PyQuery对象
    doc = pq(html)
    # print(html)
    items = doc('#body_box > div.hangkongbiao > table > tbody').items()
    for item in items:
        product = {
            'flight_no': item.find('td:nth-child(1)').text().split(' '),
            'dep_ct': item.find('td:nth-child(4)').text().split(' '),
            'arr_ct': item.find('td:nth-child(7)').text().split(' '),
            'dep_time':item.find('td:nth-child(5)').text().split(' '),
            'arr_time':item.find('td:nth-child(6)').text().split(' '),
        }
    for i in range(1,len(product['flight_no'])):
        flightno.append(product['flight_no'][i])
        depct.append(product['dep_ct'][i])
        arrct.append(product['arr_ct'][i])
        deptime.append(product['dep_time'][i])
        arrtime.append(product['arr_time'][i])
    for i in range(1,len(flightno)):
        dtime1 = deptime[i][:2]
        dtime2 = deptime[i][-2:]
        dtime = dtime1 + ':' + dtime2
        atime1 = arrtime[i][:2]
        atime2 = arrtime[i][-2:]
        atime = atime1 + ':' + atime2
        myproduct = {
            'flight_no': flightno[i],
            'dep_ct': depct[i],
            'arr_ct': arrct[i],
            'dep_time': dtime,
            'arr_time': atime
        }
        result.append(myproduct)

def main():
    get_products()
    print(result)

    pf = pd.DataFrame(result)
    # 指定字段顺序
    column = ['flight_no', 'dep_ct', 'arr_ct', 'dep_time', 'arr_time']
    pf = pf[column]
    pf.to_excel('./airDataFuZhou.xls', index=False)

if __name__ == '__main__':
    main()

