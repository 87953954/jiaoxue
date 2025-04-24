import { createApp } from 'vue';
import App from './App.vue';
//import ElementPlus from 'element-plus';
//import 'element-plus/dist/index.css';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import router from './router';

const app = createApp(App);

app.use(Antd);
app.use(router);
app.mount('#app');