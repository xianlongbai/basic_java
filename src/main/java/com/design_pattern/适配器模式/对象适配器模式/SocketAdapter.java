package com.design_pattern.适配器模式.对象适配器模式;

/**
 * Created by root on 2019/5/14.
 */
public class SocketAdapter implements DBSocketInterface {

    //组合新接口
    private GBSocketInterface gbSocket;


    /**
     * 在创建适配器对象时，必须传入一个新街口的实现类
     * @param gbSocket
     */
    public SocketAdapter(GBSocketInterface gbSocket) {
        this.gbSocket = gbSocket;
    }

    /**
     * 将对就接口的调用适配到新接口
     */
    @Override
    public void powerWithTwoRound() {

        gbSocket.powerWithThreeFlat();
    }
}
