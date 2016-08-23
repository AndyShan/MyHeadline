#  -*- coding: utf-8 -*-
import urllib2
from bs4 import BeautifulSoup
import jieba.analyse
import sys
import time
import json

reload(sys)

sys.setdefaultencoding('utf-8')

yuele_Url = 'http://yule.baidu.com/'
caijing_Url = 'http://finance.baidu.com/'


def yule():
    f = open('hehe.txt','a')
    content = urllib2.urlopen(yuele_Url).read()
    soup = BeautifulSoup(content, from_encoding = 'gbk')
    yuele_News = soup.find_all('ul', {'class', 'ulist '})[0].find_all('li')

    for i in yuele_News:
        title = i.a.text.decode()
        labels = get_keyword(i.a.text)
        data = str(GetNowTime())
        href = i.a['href']
        label = '娱乐,'
        for i in range(len(labels) - 1):
            label += str(labels[i]) + ','
        label += labels[len(labels) - 1]
        f.write(str(title) + '\t' + str(label) + '\t' + data + '\t' + href + '\n')

def caijing():
    f = open('hehe.txt','a')
    content = urllib2.urlopen(caijing_Url).read()
    soup = BeautifulSoup(content, from_encoding = 'gbk')
    caijing_News = soup.find_all('ul', {'class', 'ulist fb-list'})[0].find_all('li')

    for i in caijing_News:
        title = i.a.text.decode()
        labels = get_keyword(i.a.text)
        data = str(GetNowTime())
        href = i.a['href']
        label = '财经,'
        for i in range(len(labels) - 1):
            label += str(labels[i]) + ','
        label += labels[len(labels) - 1]
        f.write(str(title) + '\t' + str(label) + '\t' + data + '\t' + href + '\n')


def search(content):
    url = "http://news.baidu.com/ns?word=" + content + "&bs=%D6%D0%B9%FA%C5%AE%C5%C5&sr=0&cl=2&rn=20&tn=news&ct=0&clk=sortbytime"
    content = urllib2.urlopen(url).read()
    soup = BeautifulSoup(content,from_encoding='gbk')
    searchnews = soup.find_all('h3',{'class','c-title'})[0]
    my_new = {"title":searchnews.a.text,"label":get_keyword(searchnews.a.text),"date":GetNowTime(),"href":searchnews.a['href']}
    return json.dumps(my_new)


def get_keyword(content):
    words = jieba.analyse.extract_tags(content)
    re = []
    for i in words:
        re.append(i.decode())
    return re

def GetNowTime():
    return time.strftime("%Y-%m-%d %H:%M:%S",time.localtime(time.time()))

if __name__ == "__main__":
    # index = 0
    # while True:
    #     print index
    #     print "*****************爬取中*****************"
    #     f = open('hehe.txt','a')
    #     news = []
    #     news.append(yule())
    #     news.append(caijing())
    #     print "*****************写入中*****************"
    #     f.write(json.dumps(news) + '\n')
    #     print "*****************等待中*****************"
    #     time.sleep(60 * 60)
    #     index += 1
    # print search('李晓霞')
    yule()
    caijing()