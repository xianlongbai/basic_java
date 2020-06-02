package com.apacheftp;

import org.apache.ftpserver.ftplet.*;

import java.io.IOException;

public class MyFirstLet extends DefaultFtplet {


    @Override
    public FtpletResult onConnect(FtpSession session) throws FtpException, IOException {
        System.out.println("连接ftp!");
        return super.onConnect(session);
    }

    @Override
    public FtpletResult onUploadStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onUploadStart(session, request);
    }

    @Override
    public FtpletResult onUploadEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        return super.onUploadEnd(session, request);
    }

    @Override
    public FtpletResult onDownloadStart(FtpSession session, FtpRequest request) throws FtpException, IOException {
        System.out.println("开始下载~");
        return super.onDownloadStart(session, request);
    }

    @Override
    public FtpletResult onDownloadEnd(FtpSession session, FtpRequest request) throws FtpException, IOException {
        System.out.println("下载完成~");
        return super.onDownloadEnd(session, request);
    }

    @Override
    public FtpletResult onDisconnect(FtpSession session) throws FtpException, IOException {
        System.out.println("ftp连接关闭！");
        return super.onDisconnect(session);
    }

    @Override
    public void destroy() {
        System.out.println("ftp连接销毁！");
        super.destroy();
    }

}
