// 获取想要操作的元素
let switchCtn = document.querySelector("#switch-cnt")
let switchC1 = document.querySelector("#switch-c1")
let switchC2 = document.querySelector("#switch-c2")
let switchCircle = document.querySelectorAll(".switch_circle")
let switchBtn = document.querySelectorAll(".switch_btn")
let part1 = document.querySelector("#part1")
let part2 = document.querySelector("#part2")
let allButtons = document.querySelectorAll(".form_btn");
// 防止提交时页面刷新丢失动效，设置一个事件对象防止页面自动刷新
let getButtons = (e) => e.preventDefault()
// 修改状态
let changeForm = (e) => {
    // 鼠标事件后改变盒性质的函数,cc=content change
    switchCtn.classList.add("is_cc")
    setTimeout(function () {
        // 延迟1.5s后移除类名,与样式中的1.25s配合
        switchCtn.classList.remove("is_cc")
    }, 1500)
    // 较小盒子的左右状态切换
    switchCtn.classList.toggle("is_changetR")
    switchCircle[0].classList.toggle("is_changetR")
    switchCircle[1].classList.toggle("is_changetR")
    // 注册，登录显示切换
    switchC1.classList.toggle("is_hidden")
    switchC2.classList.toggle("is_hidden")
    // 较大盒子的左右状态及层叠顺序切换
    part1.classList.toggle("is_changetL")
    part2.classList.toggle("is_changetL")
    part2.classList.toggle("is_z")
}
let changehappen = (e) => {
    // 为大盒子中按钮添加点击事件的监听器，阻止页面刷新
    for (let i = 0; i < allButtons.length; i++) {
        allButtons[i].addEventListener("click", getButtons);
    }
    // 为小盒子中按钮添加点击事件的监听器，点击时执行切换
    for (let i = 0; i < switchBtn.length; i++) {
        switchBtn[i].addEventListener("click", changeForm);
    }
}
// 页面加载完成后再执行
window.addEventListener("load", changehappen)