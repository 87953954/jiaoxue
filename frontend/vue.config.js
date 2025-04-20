const { defineConfig } = require('@vue/cli-service')

module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // 后端服务器地址
        changeOrigin: true,
        pathRewrite: {
          '^/api': '/api' // 如果后端接口本身就带有 /api 前缀，可以保持不变
        }
      }
    }
  }
}) 