package com.steins.util;

import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;
import rx.Subscription;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Account {
    private static Web3j web3j;
    private static Admin admin;

    private static String fromAddress = "0xe761c26e463aa6f713567599472dac4d4a008954";
    private static String toAddress = "0xb0b3aa2f99eca8b727a0eadf7a2e4e4fd1d84d0e";
    private static BigDecimal defaultGasPrice = BigDecimal.valueOf(5);

    public static void main(String[] args) throws IOException {
        web3j = Web3j.build(new HttpService("http://localhost:8545/"));
        admin = Admin.build(new HttpService("http://localhost:8545/"));

        getBalance(fromAddress);
       sendTransaction("11111111");
        // getEthInfo();
        //getTransaction();


//        List<EthBlock.TransactionResult> txs = web3j.ethGetBlockByNumber(DefaultBlockParameter.valueOf(BigInteger.valueOf(515)), true).send().getBlock().getTransactions();
//        txs.forEach(tx -> {
//            EthBlock.TransactionObject transaction = (EthBlock.TransactionObject) tx.get();
//            System.out.println(transaction.getInput());
//        });
//
//        Request<a, EthTransaction> ethTransactionRequest = (Request<a, EthTransaction>) web3j.ethGetTransactionByHash("0xf9d1d8665158d050a5d6afa10b4968d14f1d6305873ba209f5525b68b0e207fe");
//        List<a> params = ethTransactionRequest.getParams();
//        System.out.println(params);
//       // List<a> params = sad.getParams();
//       // System.out.println(params);
//        EthBlock.TransactionResult  transactionResult= (EthBlock.TransactionResult) web3j.ethGetTransactionByHash("0xf9d1d8665158d050a5d6afa10b4968d14f1d6305873ba209f5525b68b0e207fe");
//        EthBlock.TransactionObject transactionObject = (EthBlock.TransactionObject) transactionResult.get();
//        String input = transactionObject.getInput();
//        System.out.println(input);
    }

    /**
     * 获取余额
     *
     * @param address 钱包地址
     * @return 余额
     */
    public static BigInteger getBalance(String address) {
        BigInteger balance = null;
        try {
            EthGetBalance ethGetBalance = web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();//
            balance = ethGetBalance.getBalance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("address: " + address + " balance: " + balance);
        return balance;
    }

//    /**
//     * 生成一个普通交易对象
//     *
//     * @param fromAddress 放款方
//     * @param toAddress   收款方
//     * @param nonce       交易序号
//     * @param gasPrice    gas 价格
//     * @param gasLimit    gas 数量
//     * @param value       金额
//     * @return 交易对象
//     */
//    private static Transaction makeTransaction(String fromAddress, String toAddress,
//                                               BigInteger nonce, BigInteger gasPrice,
//                                               BigInteger gasLimit, BigInteger value) {
//        Transaction transaction;
//        transaction = Transaction.createEtherTransaction(fromAddress, nonce, gasPrice, gasLimit, toAddress, value);
//        return transaction;
//    }

    /**
     * 获取普通交易的gas上限
     *
     * @param transaction 交易对象
     * @return gas 上限
     */
//    private static BigInteger getTransactionGasLimit(Transaction transaction) {
//        BigInteger gasLimit = BigInteger.ZERO;
//        try {
//            EthEstimateGas ethEstimateGas = web3j.ethEstimateGas(transaction).send();
//            //gasLimit = ethEstimateGas.getAmountUsed();
//            gasLimit = BigInteger.valueOf(1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return gasLimit;
//    }

    /**
     * 获取账号交易次数 nonce
     *
     * @param address 钱包地址
     * @return nonce
     */
    private static BigInteger getTransactionNonce(String address) {
        BigInteger nonce = BigInteger.ZERO;
        try {
            EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(address, DefaultBlockParameterName.PENDING).send();
            nonce = ethGetTransactionCount.getTransactionCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nonce;
    }


    /**
     * 发送一个普通交易
     *
     * @return 交易 Hash
     */
     public static String sendTransaction(String data) {
        String password = "123456";
        BigInteger unlockDuration = BigInteger.valueOf(60L);
        BigDecimal amount = new BigDecimal("0.01");
        String txHash = null;
        //String path = "D:\\Ethereum\\keystore\\UTC--2019-05-26T09-42-12.071184200Z--3509db2c944460e1b8c6df9c7e595134712864db";
        String path = "/Users/apple/Desktop/Mychain/data0/keystore/UTC--2019-05-26T04-34-20.742185700Z--e761c26e463aa6f713567599472dac4d4a008954";

        try {
            //新建钱包
            Credentials Swingland = WalletUtils.loadCredentials("123456", path);
         //   PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(fromAddress, password, unlockDuration).send();

                String message = null;
                BigInteger value = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();
//            Transaction transaction = makeTransaction(fromAddress, toAddress,
//                    null, null, null, value);
                //不是必须的 可以使用默认值
                //  BigInteger gasLimit = getTransactionGasLimit(transaction);
                BigInteger gasLimit = BigInteger.valueOf(1000000);
                //不是必须的 缺省值就是正确的值
                BigInteger nonce = getTransactionNonce(fromAddress);
                //该值为大部分矿工可接受的gasPrice
                BigInteger gasPrice = Convert.toWei(defaultGasPrice, Convert.Unit.GWEI).toBigInteger();
                //生成RawTransaction交易对象
                RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, toAddress, value, data);//可以额外带数据
                //使用Credentials对象对RawTransaction对象进行签名
                byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, Swingland);
                String hexValue = Numeric.toHexString(signedMessage);
                EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();
                txHash = ethSendTransaction.getTransactionHash();
            } catch(CipherException | IOException | InterruptedException | ExecutionException e1){
                e1.printStackTrace();
            }
            System.out.println("tx hasrh " + txHash);
            return txHash;
        }


    /**
     * 字符串转换成为16进制(无需Unicode编码)
     * @param str
     * @return
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
            // sb.append(' ');
        }
        return sb.toString().trim();
    }

    /**
     * 16进制直接转换成为字符串(无需Unicode解码)
     * @param hexStr
     * @return
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

        //使用 web3j.ethSendRawTransaction() 发送交易 需要用私钥自签名交易 详见ColdWallet.java


    /**
     * 请求区块链的信息
     */
    private static void getEthInfo() {

        Web3ClientVersion web3ClientVersion = null;
        try {
            //客户端版本
            web3ClientVersion = web3j.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            System.out.println("clientVersion " + clientVersion);
            //区块数量
            EthBlockNumber ethBlockNumber = web3j.ethBlockNumber().send();
            BigInteger blockNumber = ethBlockNumber.getBlockNumber();
            System.out.println("区块数量" + blockNumber);
            //挖矿奖励账户
            EthCoinbase ethCoinbase = web3j.ethCoinbase().send();
            String coinbaseAddress = ethCoinbase.getAddress();
            System.out.println("挖矿奖励账户" + coinbaseAddress);
            //是否在同步区块
            EthSyncing ethSyncing = web3j.ethSyncing().send();
            boolean isSyncing = ethSyncing.isSyncing();
            System.out.println("是否在同步区块" + isSyncing);
            //是否在挖矿
            EthMining ethMining = web3j.ethMining().send();
            boolean isMining = ethMining.isMining();
            System.out.println("是否在挖矿" + isMining);
            //当前gas price
            EthGasPrice ethGasPrice = web3j.ethGasPrice().send();
            BigInteger gasPrice = ethGasPrice.getGasPrice();
            System.out.println("当前gas price" + gasPrice);
            //挖矿速度
            EthHashrate ethHashrate = web3j.ethHashrate().send();
            BigInteger hashRate = ethHashrate.getHashrate();
            System.out.println("挖矿速度" + hashRate);
            //协议版本
            EthProtocolVersion ethProtocolVersion = web3j.ethProtocolVersion().send();
            String protocolVersion = ethProtocolVersion.getProtocolVersion();
            System.out.println("协议版本" + protocolVersion);
            //连接的节点数
            NetPeerCount netPeerCount = web3j.netPeerCount().send();
            BigInteger peerCount = netPeerCount.getQuantity();
            System.out.println("连接的节点数" + peerCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public static String getTransaction(String goalTx) {
        BigInteger startBlock = BigInteger.valueOf(400);
        BigInteger endBlock = BigInteger.valueOf(550);
        System.out.println("replay transaction+yingyingying");
         final String[] goalString = {""};
         String temp;
        Subscription subscription1 = web3j.
                replayTransactionsObservable(
                        DefaultBlockParameter.valueOf(startBlock),
                        DefaultBlockParameter.valueOf(endBlock)).
                subscribe(transaction -> {
                        if (transaction.getHash().equals(goalTx)){
                            goalString[0] =  transaction.getInput();

                        }
                    System.out.println("replay transaction");
                    System.out.println(transaction.getFrom());
                });
        return goalString[0];
    }
}
