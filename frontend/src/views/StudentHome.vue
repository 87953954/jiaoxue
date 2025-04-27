<template>
  <a-layout>
    <a-layout-header class="header">
        <div class="user-info">
            <a-avatar size="large" icon="user" />
            <span class="user-name">Student/Parent</span>
        </div>
        <a-button type="primary" @click="logout">
            退出
        </a-button>
    </a-layout-header>
    <a-layout-content class="content">
        <div class="announcement">
            <a-typography-title level="5">公告栏</a-typography-title>
             <a-list :data-source="announcements" class="announcement-list" bordered>
                <template #renderItem="{ item }">
                    <a-list-item>
                       <a-typography-text>{{item}}</a-typography-text>
                    </a-list-item>
                </template>
            </a-list>
        </div>
        <a-carousel autoplay class="carousel">
            <div v-for="item in carouselItems" :key="item" class="carousel-item">
                <img :src="item" alt="Carousel Image" class="carousel-image" />
            </div>
        </a-carousel>
        <div class="feature-modules">
            <a-row :gutter="16">
                <a-col :span="8" v-for="feature in features" :key="feature.title">
                    <a-card :bordered="false" class="feature-card">
                        <template #cover>
                            <a-icon :component="feature.icon" style="font-size: 48px" />
              </template>
              <a-typography-paragraph style="text-align: center;">{{ feature.title }}</a-typography-paragraph>
              <a-typography-paragraph style="text-align: center;">{{ feature.description }}</a-typography-paragraph>
            </a-card>
          </a-col>
        </a-row>
      </div>
  </a-layout-content>
  </a-layout>
</template>

<script>
import { reactive } from 'vue';
import { UserOutlined } from '@ant-design/icons-vue';
import { useRouter } from 'vue-router';

export default {
  name: 'StudentHome',
  components: {
    UserOutlined,
  },
  setup() {
    const router = useRouter();
    const announcements = reactive([
        '本周五下午进行数学测试',
        '下周一放假',
        '请按时提交作业',
    ]);
    const carouselItems = reactive([
        'https://zos.alipayobjects.com/rmsportal/AiyWuByWvjqjDBq.png',
        'https://gw.alipayobjects.com/zos/rmsportal/QiVYdrFjTqfIqQy.png',
        'https://gw.alipayobjects.com/zos/rmsportal/EJOvKYVLVLZrjDk.png',
    ]);

    const features = reactive([
        {
            title: '课程亮点1',
            description: '课程亮点1描述',
            icon: UserOutlined,
        },
        {
            title: '课程亮点2',
            description: '课程亮点2描述',
            icon: UserOutlined,
        },
        {
            title: '课程亮点3',
            description: '课程亮点3描述',
            icon: UserOutlined,
        },
    ]);
    const logout = () => {
        localStorage.removeItem('userInfo');
        router.push('/login')
    }
    return {
        announcements,
        carouselItems,
        features,
        logout
    };
  }
};
</script>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 24px;
  background-color: #fff;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
.user-info {
  display: flex;
  align-items: center;
}

.user-name {
  margin-left: 10px;
  font-weight: bold;
}
.content{
    padding: 24px;
    background-color: #f0f2f5;
}
.announcement{
    margin-bottom: 24px;
}
.carousel{
    margin-bottom: 24px;
}
.carousel-item{
    text-align: center;
    height: 160px;
    line-height: 160px;
    background: #364d79;
    overflow: hidden;
}
.carousel-image{
    width: 100%;
    height: 100%;
    object-fit: cover;
}
.feature-modules{
    margin-bottom: 24px;
}
.feature-card{
    text-align: center;
}
.student-home{
    min-height: 100vh;
}
</style>