# educhain
团队成员：刘鹏，潘仲秋，陈慧妮，马宁。
项目已上线https://rammsteinlp.cn/educhain/login.html
服务器端已配置好私有链环境。
服务器后台采用SSM框架搭建，前台使用的是bootstrap，js，css，html。前台后使用ajax进行数据交互。

已完成web端和区块链环境对接，使用的是web3j接口，可见src/main/java/com/steins/util/Account.java这个文件，区块链部分的代码全在这里。

项目功能：不同角色（老师，竞赛机构，企业公司）对于学生信息的增删改查逻辑操作。
        数据入链，数据在写入数据库时能往区块链上发送数据，待其他节点进行挖矿确认后便能写入区块。
        从链上获取数据，通过暴力遍历区块（此方法有待改善），查找想要的信息。
        
隐去了jdbc配置文件。
mysql使用的是5.1.34版本
