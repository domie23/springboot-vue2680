import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import huodong from '@/views/modules/huodong/list'
    import huodongBaoming from '@/views/modules/huodongBaoming/list'
    import huodongCollection from '@/views/modules/huodongCollection/list'
    import huodongchengbanfang from '@/views/modules/huodongchengbanfang/list'
    import huodongxuanchuan from '@/views/modules/huodongxuanchuan/list'
    import tuanwei from '@/views/modules/tuanwei/list'
    import zhiyuanzhe from '@/views/modules/zhiyuanzhe/list'
    import config from '@/views/modules/config/list'
    import dictionaryForum from '@/views/modules/dictionaryForum/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryHuodong from '@/views/modules/dictionaryHuodong/list'
    import dictionaryHuodongBaomingPingding from '@/views/modules/dictionaryHuodongBaomingPingding/list'
    import dictionaryHuodongBaomingYesno from '@/views/modules/dictionaryHuodongBaomingYesno/list'
    import dictionaryHuodongCollection from '@/views/modules/dictionaryHuodongCollection/list'
    import dictionaryHuodongchengbanfang from '@/views/modules/dictionaryHuodongchengbanfang/list'
    import dictionaryHuodongxuanchuan from '@/views/modules/dictionaryHuodongxuanchuan/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryForum',
        name: '帖子类型',
        component: dictionaryForum
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryHuodong',
        name: '活动类型',
        component: dictionaryHuodong
    }
    ,{
        path: '/dictionaryHuodongBaomingPingding',
        name: '评定结果',
        component: dictionaryHuodongBaomingPingding
    }
    ,{
        path: '/dictionaryHuodongBaomingYesno',
        name: '审核状态',
        component: dictionaryHuodongBaomingYesno
    }
    ,{
        path: '/dictionaryHuodongCollection',
        name: '收藏表类型',
        component: dictionaryHuodongCollection
    }
    ,{
        path: '/dictionaryHuodongchengbanfang',
        name: '企业行业',
        component: dictionaryHuodongchengbanfang
    }
    ,{
        path: '/dictionaryHuodongxuanchuan',
        name: '活动宣传类型',
        component: dictionaryHuodongxuanchuan
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/huodong',
        name: '活动',
        component: huodong
      }
    ,{
        path: '/huodongBaoming',
        name: '活动报名',
        component: huodongBaoming
      }
    ,{
        path: '/huodongCollection',
        name: '活动收藏',
        component: huodongCollection
      }
    ,{
        path: '/huodongchengbanfang',
        name: '活动承办方',
        component: huodongchengbanfang
      }
    ,{
        path: '/huodongxuanchuan',
        name: '活动宣传',
        component: huodongxuanchuan
      }
    ,{
        path: '/tuanwei',
        name: '团委',
        component: tuanwei
      }
    ,{
        path: '/zhiyuanzhe',
        name: '志愿者',
        component: zhiyuanzhe
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
