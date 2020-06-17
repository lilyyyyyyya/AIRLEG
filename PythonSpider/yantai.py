from pyquery import PyQuery as pq
from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import re
import xlwt
import pandas as pd

path = "D:/webdriver/chromedriver.exe"
options = webdriver.ChromeOptions()
# 设置为开发者模式，防止被各大网站识别出来使用Selenium
options.add_experimental_option('excludeSwitches',['enable-automation'])
# 创建WebDriver对象
browser = webdriver.Chrome(executable_path=path,options=options)
wait = WebDriverWait(browser,10)
browser.get("http://119.180.28.88:7777/FligthManage/FlightInfo/FlightInfo.aspx")


wait.until(EC.presence_of_element_located((By.XPATH, '//*[@id="form1"]/div[3]/div/div/div[2]/div[2]/div[2]/table')))

html = browser.page_source
# 创建PyQuery对象
doc = pq(html)

# print(html)
items = doc('#form1 > div:nth-child(5) > div > div > div.datagrid-view > div.datagrid-view2 > div.datagrid-body > table > tbody > .datagrid-row').items()
result = []
for item in items:
    flight_airline = item.find('.datagrid-cell-c1-HX').text()
    flight_ct = flight_airline.split('-')
    product = {
        'flight_no': item.find('.datagrid-cell-c1-HBH').text(),
        'dep_ct':flight_ct[0],
        'arr_ct':flight_ct[-1],
        'dep_time':item.find('.datagrid-cell-c1-QZSJQFSJ').text(),
        'arr_time':item.find('.datagrid-cell-c1-SJDDSJ').text(),
        'flight_state':item.find('.datagrid-cell-c1-HBZT').text()
    }
    result.append(product)

print(result)

pf = pd.DataFrame(result)
# 指定字段顺序
column = ['flight_no', 'dep_ct', 'arr_ct', 'dep_time', 'arr_time', 'flight_state']
pf = pf[column]

pf.to_excel('./db/test.xls', index=False)














