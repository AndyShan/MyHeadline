#  -*- coding: utf-8 -*-
from flask import Flask, jsonify,abort
import sys
import time
import json
import thread

reload(sys)
sys.setdefaultencoding( "utf-8" )

app = Flask(__name__)

@app.route('/api/v1.0/keyword/<string:task_id>',methods=['GET'])
def keyword(task_id):
    f = open('hehe.txt')
    keywords = task_id.split(' ')
    result = []
    for line in f:
        re = {}
        content = line.split("\t")
        if len(content) == 2:
            re['title'] = content[1]
            re['labels'] = ["0"]
            re['time'] = "0"
            re['href'] = "0"
            result.append(re)
        for word in keywords:
            if word in line:
                re['title'] = content[0]
                re['labels'] = content[1].split(",")
                re['time'] = content[2]
                re['href'] = content[3]
                result.append(re)
                break

    # print type(str(result).replace('u\'','\'').decode("unicode-escape"))
    return json.dumps(result)

@app.route('/api/v1.0/upload/<string:task_id>',methods=['GET'])
def upload(task_id):
    f = open("hehe.txt","a")
    keyword = task_id.split(" ")
    f.write(str(keyword[0]) + "\t" + str(keyword[1])+"\n")
    return "1"

if __name__ == '__main__':
    app.run('0.0.0.0',debug=True)

