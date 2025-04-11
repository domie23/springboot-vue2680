const base = {
    get() {
        return {
            url : "http://localhost:8080/zhiyuanzheguanli/",
            name: "zhiyuanzheguanli",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zhiyuanzheguanli/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "志愿者管理系统"
        } 
    }
}
export default base
