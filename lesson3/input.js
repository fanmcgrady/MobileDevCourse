var util = require('util.js')

Page({
    data: {
        studentId: "123",
        comment: "456",
        requestResult: ''
    },
    // 请求接口
    submit: function () {
      util.showBusy('请求中...')
      var self = this
      wx.request({
        url: 'http://localhost:8080/hello', // 接口地址
        data: self.data,
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
    },

    studentIdInput: function(e) {
      this.setData({
        studentId: e.detail.value
      })
    }
});