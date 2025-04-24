<template>
  <div class="login-container">
    <a-form
      @keyup.enter="onFinish(formState)"
      ref="formRef"
      :model="formState"
      name="basic"
      autocomplete="off"
      @finish="onFinish"
      @finishFailed="onFinishFailed"
      class="login-form"      
    >
      <div class="logo-container">
        <div class="logo">
          Logo
        </div>
      </div>
      <h1 class="login-title">用户登录</h1>
      <a-form-item          
        name="username"
        :rules="[{ required: true, message: '请输入用户名!' }]"
      >
        <a-input
          v-model:value="formState.username"
          placeholder="请输入用户名"
        />
      </a-form-item>
      <a-form-item
        name="password"
        :rules="[{ required: true, message: '请输入密码!' }]"
      >
        <a-input-password
          v-model:value="formState.password"
          placeholder="请输入密码"
        />
      </a-form-item>
      <a-form-item>
        <a-checkbox v-model:checked="formState.remember">记住我</a-checkbox>
        <a-link @click="goToForgetPassword" style="float: right">
          忘记密码
        </a-link>
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit" class="login-button">
          登录
        </a-button>
      </a-form-item>
      <div class="copyright">© 2024 Teaching Management System. All rights reserved.</div>
      <a-form-item>
        <a-link href="#" class="register-link">立即注册</a-link>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup>
import { reactive, ref } from 'vue';
import { message } from 'ant-design-vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();
const formRef = ref();
const formState = reactive({
  username: '',
  password: '',
  remember: false,
});

// 跳转到忘记密码页面的方法
const goToForgetPassword = () => {
  router.push('/forgetPassword');
};

const goToRegister = () => {
  router.push('/register');
};

const onFinish = async (values) => {
  try {
    const response = await axios.post('/api/login', {
      username: values.username,
      password: values.password,
    });
    if (response.data.status === 'success') {
      localStorage.setItem('user', JSON.stringify(response.data.data));
      message.success('登录成功！');
      router.push('/studentHome');
    } else {
      message.error('用户名或密码错误！');
    }
  } catch (error) {
    console.error('登录失败:', error);
    message.error('登录失败，请检查网络或稍后重试！');
  }
};

const onFinishFailed = (errorInfo) => {
  console.log('Failed:', errorInfo);
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f2f5;
  font-family: Arial, sans-serif;
  color: #333;
}

.login-form {
  width: 350px;
  padding: 40px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.logo {
  text-align: center;
  margin-bottom: 20px;
  font-size: 24px;
  font-weight: bold;
}

.ant-input, .ant-input-password {
  border-color: #d9d9d9;
  font-size: 14px;
  padding: 10px;
  height: 40px;
}

.ant-btn-primary {
  background-color: #1890ff;
  border-color: #1890ff;
  font-size: 14px;
}

.ant-btn-primary:hover {
  background-color: #40a9ff;
  border-color: #40a9ff;
}

.register-link:hover {
  color: #40a9ff;
}

.logo-container {
  text-align: center;
  margin-bottom: 20px;
}

.login-title {
  text-align: center;
  margin-bottom: 20px;
}

.login-button {
  width: 100%;
  height: 40px;
}

.copyright {
  text-align: center;
  font-size: 12px;
  color: #999;
}

/* 移动端适配 */
@media (max-width: 576px) {
  .login-form {
    width: 90%;
    padding: 20px;
  }
}
</style>