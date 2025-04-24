<template>
  <a-layout class="user-list-container">
    <a-layout-content class="user-list-content">
      <a-input-search
        style="width: 30%; margin-bottom: 20px"
        v-model:value="searchKeyword"
        placeholder="请输入用户名/姓名/学号搜索"
        enter-button
        class="search-input"
        @search="handleSearch"
      />
      <a-table
        :columns="columns"
        :data-source="data"
        :pagination="pagination"
        :loading="loading"
        @change="handleTableChange"
        bordered
        rowKey="id"
      >
        <template #bodyCell="{ column, record }"> <template v-if="column.dataIndex==='registrationTime'"> {{new Date(record.registrationTime).toLocaleDateString()}} </template> </template>
      </a-table>
    </a-layout-content>
  </a-layout>
</template>

<script>
import { defineComponent, reactive, ref, onMounted } from 'vue';
import axios from 'axios';
import { message } from 'ant-design-vue';

export default defineComponent({
  name: 'UserList',
  setup() {
    const columns = [
      {
        title: '用户名',
        dataIndex: 'username',
        key: 'username',
      },
      {
        title: '姓名',
        dataIndex: 'name',
        key: 'name',
      },
      {
        title: '学号',
        dataIndex: 'studentId',
        key: 'studentId',
      },
        {
            title: '班级',
            dataIndex: 'className',
            key: 'className',
            ellipsis: true,
        },
        {
            title: '注册时间',
            dataIndex: 'registrationTime',
            key: 'registrationTime',
        },
    ];

    const data = ref([]);
    const loading = ref(false);
    const searchKeyword = ref('');
    const pagination = reactive({
      current: 1,
      pageSize: 10,
      total: 0,
      showSizeChanger: true,
      pageSizeOptions: ['10', '20', '50', '100']
    });

    const fetchData = async () => {
      loading.value = true;
      try {
        const response = await axios.get('/api/users', {
          params: {
            page: pagination.current,
            pageSize: pagination.pageSize,
            keyword: searchKeyword.value
          }
        });
        if (response.status === 200) {
          data.value = response.data.data;
          pagination.total = response.data.totalElements;
        } else {
          message.error('获取用户列表失败');
        }
      } catch (error) {
        console.error('获取用户列表失败', error);
          message.error('获取用户列表失败');
      } finally {
        loading.value = false;
      }
    };

    const handleTableChange = (page) => {
      pagination.current = page.current;
      pagination.pageSize = page.pageSize;
      fetchData();
    };

      const handleSearch = () => {
          pagination.current = 1;
          fetchData();
      }

    onMounted(fetchData);

    return {
      columns,
      data,
      loading,
      pagination,
      fetchData,
        searchKeyword,
        handleSearch,
      handleTableChange
        };
  }
});
</script>

<style scoped>
.user-list-container {
  min-height: 100vh;
  background-color: #f0f2f5;
}

.user-list-content {
  padding: 24px;

}
</style>