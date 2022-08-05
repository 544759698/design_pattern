接口鉴权设计：
1.url、appid、timestamp、参数排序、token，
2.服务端兼容一分钟内请求
3.为避免重放攻击，可服务端保存token判断是否已请求过
4.post请求可以对body体做md5作为参数进行加密生成token





实现在下一节