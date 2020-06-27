package com.steins.entity;

public class InfoHeader {
    
    private int id;  //档案编号
    private String insertTime; //录入时间
    private String updateTime; //修改时间
    private Integer blockHeight; //区块高度
    private String idNumber;     //身份在证
    private String contractAddress; //合约地址
    private Integer dataProtect; //保护状态，是否保护到公有链上，1已保护 0未保护
    private Integer dataCheck; //数据一致性,0未检查，1 一致，-1不一致
    private String dirTitle; //文件标题



    @Override
    public String toString() {
        return "InfoHeader{" +
                "id=" + id +
                ", insertTime='" + insertTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", blockHeight=" + blockHeight +
                ", idNumber='" + idNumber + '\'' +
                ", contractAddress='" + contractAddress + '\'' +
                ", dataProtect=" + dataProtect +
                ", dataCheck=" + dataCheck +
                ", dirTitle='" + dirTitle + '\'' +
                '}';
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(Integer blockHeight) {
        this.blockHeight = blockHeight;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public Integer getDataProtect() {
        return dataProtect;
    }

    public void setDataProtect(Integer dataProtect) {
        this.dataProtect = dataProtect;
    }

    public Integer getDataCheck() {
        return dataCheck;
    }

    public void setDataCheck(Integer dataCheck) {
        this.dataCheck = dataCheck;
    }

    public String getDirTitle() {
        return dirTitle;
    }

    public void setDirTitle(String dirTitle) {
        this.dirTitle = dirTitle;
    }
}
