<template>
  <a-menu mode="horizontal" :selected-keys="selectedKeys" @click="handleClick" >
    <a-menu-item key="home">
      <template #icon>
        <HomeOutlined />
      </template>
      首页
    </a-menu-item>
    <a-menu-item key="course">
      <template #icon>
        <BookOutlined />
      </template>
      我的课程
    </a-menu-item>
    <a-menu-item key="profile">
      <template #icon>
        <UserOutlined />
      </template>
      个人中心
    </a-menu-item>
  </a-menu>
</template>

<script>
import { defineComponent, ref, watch } from 'vue';
import { HomeOutlined, BookOutlined, UserOutlined } from '@ant-design/icons-vue';
import { useRouter, useRoute } from 'vue-router';

export default defineComponent({
  name: 'BottomNavigation',
  components: {
    HomeOutlined,
    BookOutlined,
    UserOutlined,
  },
  setup() {
    const router = useRouter();
    const route = useRoute();
      const selectedKeys = ref([() => {
          if (route.path === '/') return 'home';
          if(route.path === '/studentCourse') return 'course'
          return 'profile'
      }]);

    const handleClick = (e) => {
      selectedKeys.value = [e.key];
      if (e.key === 'home') {
        router.push('/studentHome');
      } else if (e.key === 'course') {
        router.push('/studentCourse');
      } else if (e.key === 'profile') {
        router.push('/studentProfile');
      }
    };

    watch(
      () => route.name,
      (newVal) => {
          if (route.path === '/') {
              selectedKeys.value = ['home'];
          }else if(route.path === '/studentCourse'){
              selectedKeys.value = ['course']
          }else selectedKeys.value = ['profile']
      },
      { immediate: true }
    );

    return {
      selectedKeys,
      handleClick,
    };
  },
});
</script>

<style scoped>
.ant-menu {
  width: 100%;
  position: fixed;
  bottom: 0;
  left: 0;
  z-index: 10;
}
</style>