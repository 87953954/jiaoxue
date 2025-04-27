<template>
  <a-layout class="student-course-container">
    <a-layout-content class="content">
      <div class="course-calendar">
        <a-calendar :value="selectedDate" @panelChange="handlePanelChange" @select="handleSelect"/>
      </div>
      <div class="course-cards">
          <a-card v-for="course in courseList" :key="course.id" class="course-card" :title="course.name" :bordered="false">
              <template #extra>
                  <a-tag color="blue" v-if="course.status==='ongoing'">进行中</a-tag>
                  <a-tag color="green" v-if="course.status==='finished'">已结束</a-tag>
              </template>
              <div>教师：{{ course.teacher }}</div>
              <div>时间：{{ course.time }}</div>
              <div>教室：{{ course.classroom }}</div>
              <div class="card-footer">
                  <a-button type="primary" size="small" v-if="isToday(course.time)">考勤打卡</a-button>
                  <a-button type="dashed" size="small" v-if="course.status==='finished'">课程评价</a-button>
              </div>
          </a-card>
      </div>
    </a-layout-content>
  </a-layout>
</template>

<script>
import { reactive, ref, onMounted } from 'vue';
import dayjs from 'dayjs';
export default {
  name: 'StudentCourse',
  setup(){
      const selectedDate = ref(dayjs());
      const handlePanelChange = (value, mode) => {
          console.log('onPanelChange', value, mode);
      };
      const handleSelect = (value) => {
          console.log('handleSelect',value)
      }
      const isToday = (time) => {
          const today = dayjs();
          const courseDay = dayjs(time,'YYYY-MM-DD HH:mm');
          return today.isSame(courseDay, 'day');
      }
      const courseList = reactive([
          {
              id: 1,
              name: '数学',
              teacher: '张老师',
              time: '2024-07-24 08:00',
              classroom: '101',
              status: 'ongoing'
          },
          {
              id: 2,
              name: '语文',
              teacher: '李老师',
              time: '2024-07-25 10:00',
              classroom: '102',
              status: 'ongoing'
          },
          {
              id: 3,
              name: '英语',
              teacher: '王老师',
              time: '2024-07-26 14:00',
              classroom: '103',
              status: 'finished'
          },
      ]);
      return {
          selectedDate,
          handlePanelChange,
          handleSelect,
          courseList,
          isToday
      }
  }
};
</script>

<style scoped>
.student-course-container {
  min-height: 100vh;
  background-color: #f0f2f5;
}

.content {
  padding: 24px;
}
.course-calendar,
.course-cards{
    margin-bottom: 20px;
}
.course-card{
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    margin-bottom: 20px;
}
.card-footer{
    margin-top: 10px;
}
</style>