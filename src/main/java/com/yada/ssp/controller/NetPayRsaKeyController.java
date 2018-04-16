package com.yada.ssp.controller;

import com.yada.mybatis.paging.Page;
import com.yada.ssp.model.NetPayRsaKey;
import com.yada.ssp.query.NetPayRsaKeyQuery;
import com.yada.ssp.service.NetPayRsaKeyManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Random;
/**
 * @author xianyong
 */
@Controller
public class NetPayRsaKeyController {
    private static Key m_publicKey;
    private static Key m_privateKey;

    /**
     * 指定加密算法为DESede
     */
    private static String KEY_ALGORITHM = "RSA";
    private static String CIPHER_ALGORITHM = "RSA/ECB/NoPadding";//"RSA/ECB/PKCS1Padding";
    /**
     * 指定key的大小
     */
    private static int KEYSIZE = 1024;


    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    @Autowired
    private NetPayRsaKeyManager netPayRsaKeyManager;

    @RequestMapping
    public String list(Model model, NetPayRsaKeyQuery query) {
        query.setShow(true);
        Page page = netPayRsaKeyManager.queryPage(query);
        model.addAttribute("page",page);
        return "ssp_pages/NetPayRsaKey/list";
    }

    @RequestMapping
    public String show(Model model, String keyVer) {
        NetPayRsaKey netPayRsaKey = netPayRsaKeyManager.getById(keyVer);
        model.addAttribute("model", netPayRsaKey);
        return "ssp_pages/NetPayRsaKey/show";
    }

    @RequestMapping
    public String delete(String keyVer) {
        netPayRsaKeyManager.delete(keyVer);
        return "redirect:list.do";
    }

    @RequestMapping
    public String create(NetPayRsaKey netPayRsaKey) {
        Random random = new Random();
        Long x = Long.valueOf(random.nextInt(899999));
        x = x + 100000;
        String number = x.toString();
        try {
            encrypt(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String keyVersion = netPayRsaKeyManager.findByMaxKeyVersion();
        netPayRsaKey.setKeyVer(keyVersion);
        netPayRsaKey.setPublicE(bytesToHexString(((RSAPublicKey)m_publicKey).getPublicExponent().toByteArray()));
        netPayRsaKey.setPublicM(bytesToHexString(((RSAPublicKey)m_publicKey).getModulus().toByteArray()).substring(2));
        netPayRsaKey.setPrivateD(bytesToHexString(((RSAPrivateKey) m_privateKey).getPrivateExponent().toByteArray()));
        netPayRsaKey.setPrivateM(bytesToHexString(((RSAPrivateKey) m_privateKey).getModulus().toByteArray()).substring(2));
        netPayRsaKeyManager.insert(netPayRsaKey);
        return "redirect:list.do";
    }


    public static void main(String[] args)throws Exception
    {
        Random random = new Random();
        Long x = Long.valueOf(random.nextInt(899999));
        x = x + 100000;
        String number = x.toString();
        try {
            encrypt(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String source = "123456";//要加密的字符串
        /*String cryptograph = encrypt(source);//生成的密文*/
        System.out.println("公钥e:" + bytesToHexString(((RSAPublicKey)m_publicKey).getPublicExponent().toByteArray()));
        System.out.println("公钥m:" + bytesToHexString(((RSAPublicKey)m_publicKey).getModulus().toByteArray()).substring(2));
        System.out.println("公钥m:" + bytesToHexString(((RSAPublicKey)m_publicKey).getModulus().toByteArray()));
        System.out.println("私钥d:" + bytesToHexString(((RSAPrivateKey)m_privateKey).getPrivateExponent().toByteArray()));
        System.out.println("私钥m:" + bytesToHexString(((RSAPrivateKey)m_privateKey).getModulus().toByteArray()).substring(2));
        /*System.out.println("密文:" + cryptograph);*/
        System.out.println("length:"+bytesToHexString(((RSAPublicKey)m_publicKey).getModulus().toByteArray()).length());
        System.out.println("length:"+bytesToHexString(((RSAPublicKey)m_publicKey).getModulus().toByteArray()).substring(2).length());
        String a= "abcdefg".substring(3);
        System.out.println(a);
//        String target = decrypt(cryptograph);
//        System.out.println( target );


    }


    public static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * 生成密钥对
     */
    private static void generateKeyPair() throws Exception {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEYSIZE, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /** 得到公钥 */
        m_publicKey = kp.getPublic();
        /** 得到私钥 */
        m_privateKey = kp.getPrivate();
    }

    /**
     * 加密方法 source： 源数据
     */
    public static String encrypt(String source) throws Exception {
        generateKeyPair();
        /** 将文件中的公钥对象读出 */
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, m_publicKey);
        byte[] b = source.getBytes();
        /** 执行加密操作 */
        byte[] b1 = cipher.doFinal(b);

        String strRet = bytesToHexString(b1);
        return strRet;
    }

    /**
     * 解密算法 cryptograph:密文
     */
    public static String decrypt(String cryptograph) throws Exception {
        /** 将文件中的私钥对象读出 */
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, m_privateKey);
//		byte[] b1 = cryptograph.getBytes();
        byte[] b1 = hexStringToBytes(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b);
    }

}
