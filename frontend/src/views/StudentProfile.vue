<template>
  <a-layout class="student-profile-container">
    <a-layout-content class="content">
        <a-row justify="center">
            <a-col :span="12">
                <a-card :bordered="false" class="card">
                    <div class="profile-avatar">
                        <a-avatar size="large" icon="user" />
                    </div>
                    <a-descriptions :column="1" bordered>
                        <a-descriptions-item label="姓名">张三</a-descriptions-item>
                        <a-descriptions-item label="学号">20230001</a-descriptions-item>
                    </a-descriptions>
                </a-card>
            </a-col>
        </a-row>
    </a-layout-content>
  </a-layout>
</template>

<script>
import { UserOutlined } from '@ant-design/icons-vue';
export default {
  name: 'StudentProfile',
    components: {
        UserOutlined,
    }
};
</script>

<style scoped>
.student-profile-container {
  min-height: 100vh;
    background-color: #f0f2f5;
}

.content {
  padding: 24px;
}
.card{
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
.profile-avatar {
    text-align: center;
    margin-bottom: 20px;
}
</style>