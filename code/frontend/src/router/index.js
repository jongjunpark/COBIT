import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Mypage from '../views/Mypage.vue'
import CodeBlock from '../views/CodeBlock.vue'
import ChangeCharacter from "../views/ChangeCharacter.vue"
import GameMap from '../views/GameMap.vue'
import Apitest from '../views/Apitest.vue'
import Test3 from '../views/Test3.vue'
import Speech from '../views/SpeechDetectionStarted.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/mypage',
    name: 'Mypage',
    component: Mypage
  },
  {
    path: '/speech',
    name: 'Speech',
    component: Speech
  },
  {
    path: '/codeblock',
    name: 'CodeBlock',
    component: CodeBlock
  },
  {
    path: '/changecharacter',
    name: 'ChangeCharacter',
    component: ChangeCharacter
  },
  {
    path: '/gamemap',
    name: 'GameMap',
    component: GameMap
  },
  {
    path: '/apitest',
    name: 'Apitest',
    component: Apitest
  },
  {
    path: '/test3',
    name: 'Test3',
    component: Test3
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
