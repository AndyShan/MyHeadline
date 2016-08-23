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
        for word in keywords:
            if word in line:
                result.append(line)
    # print type(str(result).replace('u\'','\'').decode("unicode-escape"))
    return json.dumps(result)

if __name__ == '__main__':
    app.run('0.0.0.0')

