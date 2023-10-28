package com.example.springboot2022.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot2022.entity.Data;
import com.example.springboot2022.entity.line;
import com.example.springboot2022.service.indexService;
import com.example.springboot2022.vo.DataView;
import com.example.springboot2022.vo.indexData;
import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Controller
public class indexcontroller {

    @Autowired
    private indexService a;

    @RequestMapping("/index")
    @ResponseBody
    public List<Data> queryData(){
        List<Data> list = a.list();
        return list;
    }
    @RequestMapping("/indexdata")
    @ResponseBody
    public DataView indexdata(indexData indexdata){
        //1.分页操作
        Page<Data> page=new Page<>(indexdata.getPage(),indexdata.getLimit());
        //2.模糊查询
        QueryWrapper<Data> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(!(indexdata.getName()==null),"name",indexdata.getName());
        //3.查询数据库
        a.page(page,queryWrapper);
        //4.返回数据
        DataView dataView=new DataView(page.getTotal(),page.getRecords());
        return dataView;
    }
    @RequestMapping("/edit")
    @ResponseBody
    public DataView edit(Data data) throws NoSuchAlgorithmException {
        System.out.println(data.getName()+data.getPk()+data.getMessage());
        //1.分页操作
        //Page<Data> page=new Page<>(indexdata.getPage(),indexdata.getLimit());
        //2.模糊查询
        QueryWrapper<Data> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(!(data.getName()==null),"name",data.getName());
        List<Data> data1=new ArrayList<>();
        data1=a.list(queryWrapper);
        DataView dataView=new DataView();
        if(1==1){
            dataView.setCode(200);
            String pairingFile = "database/data_ours/a.properties";
            String publicFile ="database/data_ours/pub.properties";
            String mskFile = "database/data_ours/msk.properties";
            String pkFile = "database/data_han/pk.properties";
            String skFile ="database/data_han/sk.properties";
            String signCryptFile ="database/data_han/signCrypt.properties";
            String pidFile ="database/data_han/pid.properties";
//            Pairing bp = PairingFactory.getPairing(pairingFile);
//            Properties pubProp = loadPropFromFile(publicFile);
//            String PStr = pubProp.getProperty("P");
//            String PpubStr = pubProp.getProperty("P_pub");
//            Element P = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(PStr)).getImmutable();
//            Element P_pub = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(PpubStr)).getImmutable();
//            Properties pidProp = loadPropFromFile(pidFile);
//            String IDi = pidProp.getProperty("IDsend");
//            String IDj = pidProp.getProperty("IDrec");
//            String IDb = pidProp.getProperty("IDb");
//            Properties skProp = loadPropFromFile(skFile);
//            String xbStr = skProp.getProperty("xb");
//            String ybStr = skProp.getProperty("yb");
//            Element xb = bp.getZr().newElementFromBytes(Base64.getDecoder().decode(xbStr)).getImmutable();
//            Element db = bp.getZr().newElementFromBytes(Base64.getDecoder().decode(ybStr)).getImmutable();
//            Properties pkProp = loadPropFromFile(pkFile);
//            String XiStr = pkProp.getProperty("Xsend");
//            String XjStr = pkProp.getProperty("Xrec");
//            String YiStr = pkProp.getProperty("Ysend");
//            String YjStr = pkProp.getProperty("Yrec");
//            String YbStr = pkProp.getProperty("Yb");
//            String XbStr = pkProp.getProperty("Xb");
//            Element Xi = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(XiStr)).getImmutable();
//            Element Xj = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(XjStr)).getImmutable();
//            Element Yi = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(YiStr)).getImmutable();
//            Element Yj = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(YjStr)).getImmutable();
//            Element Xb = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(XbStr)).getImmutable();
//            Element Yb = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(YbStr)).getImmutable();
//            Properties sigC = loadPropFromFile(signCryptFile);
//            String VStr = sigC.getProperty("V");
//            String TStr = sigC.getProperty("T");
//            String etaStr = sigC.getProperty("eta");
//            String TimerStr = sigC.getProperty("Timer");
//            String C_aStr = sigC.getProperty("C_a");
//            String k1Str = sigC.getProperty("k1");
//            Element V = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(VStr)).getImmutable();
//            Element T = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(TStr)).getImmutable();
//            Element C_a = bp.getZr().newElementFromBytes(Base64.getDecoder().decode(C_aStr)).getImmutable();
//            Element eta = bp.getZr().newElementFromBytes(Base64.getDecoder().decode(etaStr)).getImmutable();
//            Element k1 = bp.getZr().newElementFromBytes(Base64.getDecoder().decode(k1Str)).getImmutable();
//            String Timer = TimerStr.toString();

            // byte[] h1b_hash = sha1( IDj+Rj.toString() + P_pub.toString());
            // Element h1b = bp.getZr().newElementFromHash(h1b_hash, 0, h1b_hash.length).getImmutable();
            //  Element tb = bp.getZr().newRandomElement().getImmutable();
            // Element Tb = P.powZn(tb).getImmutable();
//            byte[] h4_hash = sha1(C_a.toString()+Xi.toString()+Yi.toString()+Xj.toString()+Yj.toString()+Xb.toString()+Yb.toString()+T.toString()+V.toString());
//            Element h4 = bp.getZr().newElementFromHash(h4_hash, 0, h4_hash.length).getImmutable();
//
//            byte[] h5_hash = sha1(C_a.toString()+Xi.toString()+Yi.toString()+Xj.toString()+Yj.toString()+Xb.toString()+Yb.toString()+T.toString()+V.toString());
//            Element h5 = bp.getZr().newElementFromHash(h5_hash, 0, h5_hash.length).getImmutable();
//
//            byte[] h6_hash = sha1(C_a.toString()+Xi.toString()+Yi.toString()+Xj.toString()+Yj.toString()+Xb.toString()+Yb.toString()+T.toString()+V.toString());
//            Element h6 = bp.getZr().newElementFromHash(h6_hash, 0, h6_hash.length).getImmutable();
//
//            byte[] h0a_hash = sha1(IDj+Xj.toString()+Yj.toString()+P_pub.toString());
//            Element h0a = bp.getZr().newElementFromHash(h0a_hash, 0, h0a_hash.length).getImmutable();
//
//            byte[] h1_hash = sha1(Xi +Yi.toString()+Xj.toString()+Yj.toString()+V.toString());
//            Element h1 = bp.getZr().newElementFromHash(h1_hash, 0, h1_hash.length).getImmutable();
//
//            byte[] h2_hash = sha1(Xi +Yi.toString()+Xj.toString()+Yj.toString()+V.toString());
//            Element h2 = bp.getZr().newElementFromHash(h2_hash, 0, h2_hash.length).getImmutable();
//
//            byte[] h3_hash = sha1(Xi +Yi.toString()+Xj.toString()+Yj.toString()+V.toString());
//            Element h3 = bp.getZr().newElementFromHash(h3_hash, 0, h3_hash.length).getImmutable();
//
//            byte[] h0d_hash = sha1(IDi+Xi.toString()+Yi.toString()+P_pub.toString());
//            Element h0d = bp.getZr().newElementFromHash(h0d_hash, 0, h0d_hash.length).getImmutable();
//
//
//            Element w = P_pub.powZn(h1.mul(h0d)).add(Yi.powZn(h1)).add(Xi.powZn(h2)).add(V.powZn(h3)).add(P_pub.powZn(h4.mul(h0a))).add(Yj.powZn(h4)).add(Xj.powZn(h5)).add(T.powZn(h6));
            //System.out.println(data.getName()+data.getPk()+data.getMessage());
            dataView.setMsg("The validation was successful and the message is ："+data.getMessage());//返回消息

        }
        else{
            dataView.setCode(100);
            dataView.setMsg("验证失败");
        }
        //System.out.println(data1.get(0).name);
        return dataView;//把消息返回

        //3.查询数据库
        //a.page(page,queryWrapper);
        //4.返回数据
        //DataView dataView=new DataView(page.getTotal(),page.getRecords());

    }
//    @RequestMapping("/line")
//    @ResponseBody
//    public Map<String,List<Integer>> line(){
//        //1.查询所有数据
//       List<line> list= a.queryline();
//       //2.添加确诊疑似等数据
//        List<Integer> confirm=new ArrayList<>();
//        List<Integer> suspecte=new ArrayList<>();
//        List<Integer> none=new ArrayList<>();
//        List<Integer> heal=new ArrayList<>();
//        List<Integer> die=new ArrayList<>();
//        for (line data: list) {
//            confirm.add(data.getConfirm());
//            suspecte.add(data.getSuspecte());
//            none.add(data.getNone());
//            heal.add(data.getHeal());
//            die.add(data.getDie());
//
//        }
//        Map<String,List<Integer>> map=new HashMap<>();
//        map.put("confirm",confirm);
//        map.put("suspecte",suspecte);
//        map.put("none",none);
//        map.put("heal",heal);
//        map.put("die",die);
//        return map;
//    }
    @RequestMapping("/deleteById")
    @ResponseBody
    public DataView deleteById(int id){
        a.removeById(id);
        DataView dataView=new DataView();
        dataView.setCode(200);
        dataView.setMsg("删除成功");
        return dataView;
    }
    public static Properties loadPropFromFile(String fileName) {
        Properties prop = new Properties();

        try {
            FileInputStream in = new FileInputStream(fileName);
            Throwable var3 = null;

            try {
                prop.load(in);
            } catch (Throwable var13) {
                var3 = var13;
                throw var13;
            } finally {
                if (in != null) {
                    if (var3 != null) {
                        try {
                            in.close();
                        } catch (Throwable var12) {
                            var3.addSuppressed(var12);
                        }
                    } else {
                        in.close();
                    }
                }

            }
        } catch (IOException var15) {
            var15.printStackTrace();
            System.out.println(fileName + " load failed!");
            System.exit(-1);
        }

        return prop;
    }
    public static byte[] sha1(String content) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(content.getBytes());
        return instance.digest();
    }
    @RequestMapping("/adddata")
    @ResponseBody
    public DataView adddata(Data data) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String pairingFile = "database/data_ours/a.properties";
        String publicFile ="database/data_ours/pub.properties";
        String mskFile = "database/data_ours/msk.properties";
        //把声明的函数体放这
        Pairing bp = PairingFactory.getPairing(pairingFile);
        Element s = bp.getZr().newRandomElement().getImmutable();
//        Properties pubProp = loadPropFromFile(publicFile);
//        String PStr = pubProp.getProperty("P");
//        String PubStr = pubProp.getProperty("P_pub");
//        Element P = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(PStr)).getImmutable();
//        Element P_pub = bp.getG1().newElementFromBytes(Base64.getDecoder().decode(PubStr)).getImmutable();
        Element P = bp.getG1().newRandomElement().getImmutable();
        Element P_pub = P.powZn(s).getImmutable();
       // Properties mskPro = loadPropFromFile(mskFile);
//        String mskStr = mskPro.getProperty("s");
//        Element s = bp.getZr().newElementFromBytes(Base64.getDecoder().decode(mskStr)).getImmutable();
        Element u = bp.getZr().newRandomElement().getImmutable();//密钥，
        Element Y = P.powZn(u).getImmutable();//公钥，把这个存在数据库中
        //String Vt = "1年";
        //  byte[] h0_hash = sha1(Vt + P_pub.powZn(r).toString() );
        String id="send";
        byte[] RIDByte = id.getBytes();
        byte[] PidByte = new byte[RIDByte.length];

        String ID = new String(PidByte, "utf-8");
        Element x = bp.getZr().newRandomElement().getImmutable();
        Element X = P.powZn(x).getImmutable();
        byte[] h0_hash = sha1(ID + X.toString() +Y.toString() +P_pub.toString());
        Element h0 = bp.getZr().newElementFromHash(h0_hash, 0, h0_hash.length).getImmutable();
        Element y = u.add(s.mul(h0)).getImmutable();

        byte[] gon=sha1(Y.toString());//公钥被哈希
        String Gong=gon.toString();
        //System.out.println(data.getMessage()+data.getName()+data.getPk());
//jiami
        Element Xi = bp.getG1().newRandomElement().getImmutable();
        Element Xj = bp.getG1().newRandomElement().getImmutable();
        Element Xb = bp.getG1().newRandomElement().getImmutable();
        Element Yi = bp.getG1().newRandomElement().getImmutable();
        Element Yj = bp.getG1().newRandomElement().getImmutable();
        Element Yb = bp.getG1().newRandomElement().getImmutable();
        Element t = bp.getZr().newRandomElement().getImmutable();
        Element  T= P.powZn(t).getImmutable();
        Element v = bp.getZr().newRandomElement().getImmutable();
        Element  V= P.powZn(v).getImmutable();
        Date date = new Date();

        String Timer = String.valueOf(date.getTime());
        System.out.println(data.getMessage()+data.getName()+data.getPk()+date.getTime());
        String str = data.getName();//消息放进去
        byte[] strByte = str.getBytes();

        //byte[] str = Ta.toString().concat(IDi.concat(Timer)).getBytes();
        Element strEle = bp.getZr().newElementFromBytes(strByte).getImmutable();
        Element k1 = bp.getZr().newRandomElement().getImmutable();
        Element C_a=strEle.mul(k1).getImmutable();
        byte[] h4_hash = sha1(C_a.toString()+Xi.toString()+Yi.toString()+Xj.toString()+Yj.toString()+Xb.toString()+Yb.toString()+T.toString()+V.toString());
        Element h4 = bp.getZr().newElementFromHash(h4_hash, 0, h4_hash.length).getImmutable();

        byte[] h5_hash = sha1(C_a.toString()+Xi.toString()+Yi.toString()+Xj.toString()+Yj.toString()+Xb.toString()+Yb.toString()+T.toString()+V.toString());
        Element h5 = bp.getZr().newElementFromHash(h5_hash, 0, h5_hash.length).getImmutable();

        byte[] h6_hash = sha1(C_a.toString()+Xi.toString()+Yi.toString()+Xj.toString()+Yj.toString()+Xb.toString()+Yb.toString()+T.toString()+V.toString());
        Element h6 = bp.getZr().newElementFromHash(h5_hash, 0, h6_hash.length).getImmutable();
        String message=str;
        String idd=""+(Math.random()*9+1)*100000;

        data.setMessage(message);
        data.setName(idd);
        data.setPk(Gong);
        boolean save = a.saveOrUpdate(data);//有值就修改，没有数值就新增
        DataView dataView=new DataView();
        if(save){
            dataView.setCode(200);
            dataView.setMsg("发送成功");
        }
        else{
            dataView.setCode(100);
            dataView.setMsg("发送失败");
        }

        return dataView;
    }
}
