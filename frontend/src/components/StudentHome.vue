<template>
  <a-layout class="student-home">
    <a-layout-header class="header">
      <div class="logo" >Logo</div>
      <div class="user-info">
        <a-avatar size="large" />
        <span class="user-name">学生姓名</span>
      </div>
    <!--  <div class="header-right">
      <a-button type="primary"  @click="handleRefresh" class="refresh-button">刷新</a-button>
      </div>
    </a-layout-header>
    <a-layout-content class="content">
      <a-row :gutter="[24, 24]">
        <a-col :span="12">
          <a-card title="我的课程" :bordered="false" class="card">
            <a-list :data-source="courseData" >
              <template #renderItem="{ item }">
                <a-list-item >
                  <a-list-item-meta>
                    <template #title>
                      {{ item.name }}
                    </template>
                    <template #description>
                      {{ item.time }} 
                    </template>
                  </a-list-item-meta>
                </a-list-item>
              </template>
            </a-list>
          </a-card>
        </a-col>
        <a-col :span="12">
          <a-card title="今日考勤" :bordered="false" class="card" ></a-card>
        </a-col>
          

        <a-col :span="12">
          <a-card title="待办事项" :bordered="false" class="card">
            <a-list :data-source="todoData">
              <template #renderItem="{ item }">
                <a-list-item><a-list-item-meta> <template #title> {{ item.title }}</template> <template #description>
                      {{ item.description }}
                    </template>
                  </a-list-item-meta>
                </a-list-item>
              </template>
            </a-list>
          </a-card>
        </a-col>
        <a-col :span="12">
          <a-card title="通知公告" :bordered="false" class="card" @click="goToAnnouncement">
            <a-list :data-source="announcementData"><template #renderItem="{ item }"> <a-list-item> <a-list-item-meta> <template #title>
                      {{ item.title }}</template>
                    
                    <template #description>
                     {{item.date}}
                    </template>
                  </a-list-item-meta>
                </a-list-item>
              </template>
            </a-list>
          </a-card>
        </a-col>
         <a-col :span="12">
          <a-card title="教学资料" :bordered="false" class="card" @click="goToTeachingMaterial">
          
          </a-card>
        </a-col>
        <a-col :span="12">
           <a-card title="教学评价" :bordered="false" class="card" @click="goToTeachingEvaluation">
              
          </a-card>
        </a-col>
      </a-row>
    </a-layout-content>
  </a-layout>
</template>


<script>
import { defineComponent, reactive} from 'vue';

export default defineComponent( {
  name: 'StudentHome',
  setup() {
    const courseData = reactive([
      { name: '数学', time: '周一 8:00'},
      { name: '英语', time: '周二 10:00' },
      { name: '语文', time: '周三 14:00' },
    ]);

    const todoData = reactive([
      { title: '完成数学作业', description: '截止日期：周五' },
      { title: '准备英语考试', description: '考试时间：下周一' },
    ]);
    const announcementData = reactive([{ title: '本周三英语考试', date: '2024/03/26' }, { title: '明天停课', date: '2024/03/25' }, { title: '本周进行英语测试', date: '2024/03/24' },]);
  
    return {
         courseData,
         todoData,
         announcementData
    }




    }
});
</script>

<style scoped>
.student-home {
   min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 24px;
  background: #fff;
  box-shadow: 0 2px 8px #f0f1f2;
    display: flex;
    align-items: center;
    justify-content: space-between; 
}
.logo {
  font-size: 20px;
  font-weight: bold;
  color: #1890ff;

}

.user-info {
    display: flex;
  align-items: center;
    margin-right: 20px;
}
.user-name {
    margin-left: 10px;
    color: #333; 
}
.content {
  padding: 24px;
  background-color: #f0f2f5;
}
.card{ height: 280px;}

</style>