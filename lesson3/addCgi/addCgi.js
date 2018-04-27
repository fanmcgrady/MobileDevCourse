var util = require('../util.js')

Page({
    data: {
        requestResult: ''
    },

    // 请求接口
    testCgi: function () {
        util.showBusy('请求中...')
        var self = this
        wx.request({
          url: 'http://localhost:8080/hello', // 接口地址
          data: {
            studentId: '11',
            comment: '22'
          },
          header: {
            'content-type': 'application/json' // 默认值
          },
          success: function (res) {
            console.log(res.data)
            util.showSuccess('请求成功完成')
            self.setData({
              requestResult: JSON.stringify(res.data)
              })
          }
        })
    }
})
