var util = require('util.js')

Page({
  data: { 
    timestamp: 1526440223416, 
    signature: "a86f64921a7a2cd8db3a8a7741ef9efdc6bea33d", 
    nonce: "YdfJSdJBnQKw6YpmNPS5MFHYnHwQbPAZ", 
    type: 3, 
    contents: {
      cardId: '84122070',
      pwd: "133099"
      },
      requestResult:null
    },
  // 请求接口
  submit: function () {
    util.showBusy('请求中...')
    var self = this
    wx.request({
      url: 'https://202.115.35.195/scu/rest', // 接口地址
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

  studentIdInput: function (e) {
    this.setData({
      studentId: e.detail.value
    })
  }
});