package com.yada.ssp.controller;

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2013
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yada.mybatis.paging.Page;
import com.yada.service.util.ConfigParamUtil;
import com.yada.ssp.model.CurSignLs;
import com.yada.ssp.query.CurSignLsQuery;
import com.yada.ssp.service.CurSignLsManager;
/**
 * @author badqiu email:badqiu(a)gmail.com
 * @version 1.0
 * @since 1.0
 */
@Controller
public class CurSignLsController {
	// 默认多列排序,example: username desc,createTime asc
		protected static final String DEFAULT_SORT_COLUMNS = null;
	@Autowired
	private CurSignLsManager curSignLsManager;

	String bm = ConfigParamUtil.getProperty("bm");//"GBK";
	/** 执行搜索 */
	@RequestMapping
	public String list(Model model,@ModelAttribute("query") CurSignLsQuery query) {
		Page page = curSignLsManager.queryPage(query);
		model.addAttribute("page", page);
		model.addAttribute("query", query);
		return "/ssp_pages/CurSignLs/list";
	}
	
	
	@RequestMapping
	private void getNomalTicket(Map<Short, byte[]> messageMap, Graphics2D g2d,
			String signFilePath,CurSignLs curSignLs) throws IOException
	{
		/*****************/
		File signFile = new File(signFilePath);
		// File logoFile = new File(getRequest().getRealPath("") +
		// "/commons/chinabanklogo.jpg");
		Image signPic = ImageIO.read(signFile);
		// Image logoPic = ImageIO.read(logoFile);
		int signWidth = signPic.getWidth(null);
		int signHeight = signPic.getHeight(null);

		int pageContentHeight = 800;// 正文部分总高度
		int borderWidght = 4;// 正文和文本边框宽度
		int contentStartHeight = 120;// 正文起始行高度
		int cols = 17;// 列间距

		Font nomarlFont = new Font("宋体", Font.PLAIN, 12);
		Font boldFont = new Font("宋体", Font.BOLD, 14);
		Font promptFont = new Font("宋体", Font.PLAIN, 9);

		FontMetrics fm = g2d.getFontMetrics();
		/*****************/
		/** 商户联 **/
		g2d.setFont(nomarlFont);
		//g2d.drawBytes(getGbkString("商户联(MERCHANT COPY)").getBytes("GBK"), offset, length, x, y);
		g2d.drawString(getGbkString("商户联(MERCHANT COPY)"), borderWidght,
				contentStartHeight += contentStartHeight / 2);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		/** 商户名称 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("商户名称(MERCHANT NAME)"), borderWidght,
				contentStartHeight += cols);
		String merName = getTagValue(messageMap, (short) 0xFF00, "an");
		int brNum = 15; // 控制文本长度，多少字换行。
		int contentRowNum = getContentRowNum(merName.length(), brNum);// 获得文本行数
		for (int i = 0, j = 1; i < contentRowNum; i++, j++)
		{
			if (j < contentRowNum)
				g2d.drawString(merName.substring(i * brNum, i * brNum + brNum),
						borderWidght, contentStartHeight += cols);
			else
				g2d.drawString(merName.substring(i * brNum, merName.length()),
						borderWidght, contentStartHeight += cols);
		}
		/** 商户英文名称 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getTagValue(messageMap, (short) 0xCF01, "an"),
				borderWidght, contentStartHeight += cols);

		/** 商户号 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("商户号(MER)  ") + curSignLs.getMerchantId(),
				borderWidght, contentStartHeight += cols);

		/** 终端号 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("终端号(TER)  ") + curSignLs.getTerminalId(),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		/** 发卡方 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF04, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("发卡方(ISSUER)  ")
							+ getTagValue(messageMap, (short) 0xFF04, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 卡号 **/
		if (!"".equals(curSignLs.getCardNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("卡号(CARD NO.)"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			String cardNo = curSignLs.getCardNo();

			// 卡号屏蔽按“前六后四”原则进行
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			int cardlen = cardNo.length();
			int lentmp = 4;
			sb2.append(cardNo);// 不屏蔽卡号时使用sb2

			sb.append(cardNo.substring(0, 6)).append(
					cardNo.substring(cardlen - 4, cardlen));
			for (int i = 0; i < cardlen - 10; ++i)
				sb.insert(6, '*');

			while (lentmp < cardlen)
			{
				sb.insert(lentmp, ' ');
				sb2.insert(lentmp, ' ');
				lentmp += 5;
				cardlen += 1;
			}
			// 电子现金交易可以通过授权码域来判断，如果授权码为“ECC001”则该笔交易为电子现金交易，不需要屏蔽卡号
			String authno = getTagValue(messageMap, (short) 0xFF07, "an");

			// 现在根据交易类型来判断，交易名称为"电子现金"即电子现金交易
			String tname =
					getTagValue(messageMap, (short) 0xFF01, "an").substring(0,
							4);

			if (tname.equals("电子现金")
					|| (getTagValue(messageMap, (short) 0xFF01, "an")
							.equals("预授权")))
				g2d.drawString(sb2.toString(), borderWidght,
						contentStartHeight += cols);
			else
				g2d.drawString(sb.toString(), borderWidght,
						contentStartHeight += cols);
		}

		/** 有效期 **/
		if (!"".equals(getExpDate(getTagValue(messageMap, (short) 0xFF05, "cn"))))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("有效期(EXP DATE):")
							+ getExpDate(getTagValue(messageMap,
									(short) 0xFF05, "cn")), borderWidght,
					contentStartHeight += cols);
		}

		/** 交易类型 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF01, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("交易类型(TXN TYPE):"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			g2d.drawString(getTagValue(messageMap, (short) 0xFF01, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 批次号 **/
		if (!"".equals(curSignLs.getBatchNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("批次号(BATCH NO.):") + curSignLs.getBatchNo(),
					borderWidght, contentStartHeight += cols);

		}
		/** 查询号 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF71, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("查询号(INVOICE NO.):")
							+ getTagValue(messageMap, (short) 0xFF71, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/** 流水号 **/
		if (!"".equals(curSignLs.getTraceNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("流水号(TRACE NO.):") + curSignLs.getTraceNo(),
					borderWidght, contentStartHeight += cols);
		}
		/** 交易日期 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF06, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("交易日期(DATE):")
							+ getTicketDate(getTagValue(messageMap,
									(short) 0xFF06, "cn")), borderWidght,
					contentStartHeight += cols);

			/** 交易时间 **/
			if (!"".equals(getTicketTime(getTagValue(messageMap,
					(short) 0xFF06, "cn"))))
			{
				g2d.setFont(nomarlFont);
				g2d.drawString(
						getGbkString("交易时间(TIME):")
								+ getTicketTime(getTagValue(messageMap,
										(short) 0xFF06, "cn")), borderWidght,
						contentStartHeight += cols);
			}
		}
		/** 授权码 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF07, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("授权码(AUTH CODE):")
							+ getTagValue(messageMap, (short) 0xFF07, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 参考号 **/
		if (!"".equals(curSignLs.getTranRrn()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("参考号(REFER NO.):") + curSignLs.getTranRrn(),
					borderWidght, contentStartHeight += cols);
		}
		/** 操作员 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF02, "cn")))
		{
			g2d.setFont(nomarlFont);
			if (getTagValue(messageMap, (short) 0xFF02, "cn").length() < 4)
			{
				g2d.drawString(
						getGbkString("操作员(OPERATOR NO):")
								+ getTagValue(messageMap, (short) 0xFF02, "cn"),
						borderWidght, contentStartHeight += cols);
			}
			else
			{
				g2d.drawString(
						getGbkString("操作员(OPERATOR NO):")
								+ getTagValue(messageMap, (short) 0xFF02, "cn")
										.substring(0, 3), borderWidght,
						contentStartHeight += cols);
			}
		}
		/** 原金额 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF02, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("原金额(ORG AMT):")
							+ getTagValue(messageMap, (short) 0xCF02, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 小费 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF08, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("消费(TIPS AMT):")
							+ getTagValue(messageMap, (short) 0xFF08, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/** 总额 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF03, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("总额(SUM AMT):"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			g2d.drawString(getTagValue(messageMap, (short) 0xCF03, "an"),
					(signWidth - fm.stringWidth(getTagValue(messageMap,
							(short) 0xCF03, "an"))) / 2, contentStartHeight +=
							cols);
		}

		/** 金额 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF04, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("金额(AMOUNT):"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			g2d.drawString(getTagValue(messageMap, (short) 0xCF04, "an"),
					(signWidth - fm.stringWidth(getTagValue(messageMap,
							(short) 0xCF04, "an"))) / 2, contentStartHeight +=
							cols);
		}

		/** 交易金额 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF05, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("交易金额(AMOUNT):"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			g2d.drawString(getTagValue(messageMap, (short) 0xCF05, "an"),
					(signWidth - fm.stringWidth(getTagValue(messageMap,
							(short) 0xCF05, "an"))) / 2, contentStartHeight +=
							cols);
		}

		/** 扣减积分数 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF47, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("扣减积分数(BONUS):"), borderWidght,
					contentStartHeight += cols);
			g2d.drawString(getTagValue(messageMap, (short) 0xFF47, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/** 总金额 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF06, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("总金额(AMT):"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			g2d.drawString(getTagValue(messageMap, (short) 0xCF06, "an"),
					(signWidth - fm.stringWidth(getTagValue(messageMap,
							(short) 0xCF06, "an"))) / 2, contentStartHeight +=
							cols);
		}

		/** 原查询号 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF60, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("原查询号:")
							+ getTagValue(messageMap, (short) 0xFF60, "cn"),
					borderWidght, contentStartHeight += cols);
		}
		/** 手续费 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF07, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("手续费:")
							+ getTagValue(messageMap, (short) 0xCF07, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 代收种类 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF08, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("代收种类：")
							+ getTagValue(messageMap, (short) 0xCF08, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 代付种类 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF09, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("代付种类：")
							+ getTagValue(messageMap, (short) 0xCF09, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 用户号 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF0a, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("用户号：")
							+ getTagValue(messageMap, (short) 0xCF0a, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 分期手续费 **/
		StringBuilder sbt = new StringBuilder();
		String sqs = getTagValue(messageMap, (short) 0xFF41, "cn");
		String sjhh = getTagValue(messageMap, (short) 0xCF0b, "an");
		if (!"".equals(sqs))
		{
			sbt.append(getGbkString("期数：")).append(sqs + " ");
		}
		if (!"".equals(sjhh))
		{
			sbt.append(getGbkString("计划号：")).append(sjhh);
		}

		if (!"".equals(sqs) || !"".equals(sjhh))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(sbt.toString(), borderWidght, contentStartHeight +=
					cols);
		}

		/** 首付金额 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF42, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("首付金额：")
							+ getTagValue(messageMap, (short) 0xFF42, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 月还金额 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF0c, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("月还金额：")
							+ getTagValue(messageMap, (short) 0xCF0c, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 手续费 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF44, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("手续费：")
							+ getTagValue(messageMap, (short) 0xFF44, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 转入卡号 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF25, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("转入卡号：")
							+ getTagValue(messageMap, (short) 0xFF25, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/** IC卡详单 **/
		/** 第一行 **/
		sbt = new StringBuilder();
		String stc = getTagValue(messageMap, (short) 0xFF23, "cn");
		String satc = getTagValue(messageMap, (short) 0xFF2a, "cn");
		if (!"".equals(satc))
		{
			sbt.append(getGbkString("TC:")).append(stc + " ");
		}
		if (!"".equals(satc))
		{
			sbt.append(getGbkString("ATC:")).append(satc);
		}
		if (!"".equals(satc) || !"".equals(satc))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(sbt.toString(), borderWidght, contentStartHeight +=
					cols);
		}

		/* ATC */
		/** 第二行 **/
		String stvr = getTagValue(messageMap, (short) 0xFF28, "cn");
		String scid = getTagValue(messageMap, (short) 0xCF12, "cn");
		String stsi = getTagValue(messageMap, (short) 0xFF29, "cn");
		sbt = new StringBuilder();
		if (!scid.equals(""))
		{
			sbt.append(getGbkString("CID:")).append(scid + "  ");
		}
		if (!stsi.equals(""))
		{
			sbt.append(getGbkString("TSI:")).append(stsi + "  ");
		}
		if (!stvr.equals(""))
		{
			sbt.append(getGbkString("TVR:")).append(stvr + "  ");
		}
		if (!scid.equals("") || !stsi.equals("") || !stvr.equals(""))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(sbt.toString(), borderWidght, contentStartHeight +=
					cols);
		}

		/** 第三行 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF22, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("AID:")
							+ getTagValue(messageMap, (short) 0xFF22, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/** 第四行 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF30, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("APP LABEL:")
							+ getTagValue(messageMap, (short) 0xFF30, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 第五行* RAND */
		sbt = new StringBuilder();
		String srand = getTagValue(messageMap, (short) 0xFF26, "cn");
		String saip = getTagValue(messageMap, (short) 0xFF27, "cn");
		if (!"".equals(srand))
		{
			sbt.append(getGbkString("RAND：")).append(srand + "  ");
		}
		if (!"".equals(saip))
		{
			sbt.append(getGbkString("AIP：")).append(saip);
		}
		if (!"".equals(srand) || !"".equals(saip))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(sbt.toString(), borderWidght, contentStartHeight +=
					cols);
		}

		/** 第六行 ARC **/
		sbt = new StringBuilder();
		String sarc = getTagValue(messageMap, (short) 0xCF0e, "an");
		String scvr = getTagValue(messageMap, (short) 0xCF0d, "an");
		if (!"".equals(sarc))
		{
			sbt.append(getGbkString("ARC：")).append(sarc + "  ");
		}
		if (!"".equals(scvr))
		{
			sbt.append(getGbkString("CVR：")).append(scvr);
		}
		if (!"".equals(sarc) || !"".equals(scvr))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(sbt.toString(), borderWidght, contentStartHeight +=
					cols);
		}

		/** 持卡人 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xCF10, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("持卡人：")
							+ getTagValue(messageMap, (short) 0xCF10, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 备注 **/
		g2d.setFont(nomarlFont);
		if (!"".equals(getTagValue(messageMap, (short) 0xFF40, "an")))
		{
			g2d.drawString(getGbkString("备注(REFERENCE)"), borderWidght,
					contentStartHeight += cols);
			g2d.drawString(getTagValue(messageMap, (short) 0xFF40, "an"),
					borderWidght, contentStartHeight += cols);
		}
		else
		{
			g2d.drawString(getGbkString("备注(REFERENCE)"), borderWidght,
					contentStartHeight += cols);
		}

		/** 温馨提示 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("温馨提示:"), borderWidght,
				contentStartHeight += cols);
		g2d.drawString(getTagValue(messageMap, (short) 0xCF11, "an"),
				borderWidght, contentStartHeight += cols);

		/** 持卡人签名 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("持卡人签名(CARDHOLDER SIGNATURE)"),
				borderWidght, contentStartHeight += cols);

		/** 小票签名 **/
		g2d.drawImage(signPic, 0, contentStartHeight += cols, signWidth,
				signHeight, null);

		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols * 9);
		/** 最下方提示 **/
		g2d.setFont(promptFont);
		g2d.drawString(getGbkString("本人确认以上交易同意将其记入本账户"), borderWidght,
				contentStartHeight += cols);
		g2d.drawString(getGbkString("I ACKNOWLEDGE SATISFACTORY RECEIPT OF"),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString("ELATIVE GOODS/SERVICES."), borderWidght,
				contentStartHeight += cols);

		g2d.dispose();
	}

	@RequestMapping
	private void getDccVisaTicket(Map<Short, byte[]> messageMap,
			Graphics2D g2d, String signFilePath,CurSignLs curSignLs) throws IOException
	{
		/*****************/
		File signFile = new File(signFilePath);
		// File logoFile = new File(getRequest().getRealPath("") +
		// "/commons/chinabanklogo.jpg");
		Image signPic = ImageIO.read(signFile);
		// Image logoPic = ImageIO.read(logoFile);
		int signWidth = signPic.getWidth(null);
		int signHeight = signPic.getHeight(null);

		int pageContentHeight = 1000;// 正文部分总高度
		int borderWidght = 4;// 正文和文本边框宽度
		int contentStartHeight = 120;// 正文起始行高度
		int cols = 17;// 列间距

		Font nomarlFont = new Font("宋体", Font.PLAIN, 12);
		Font boldFont = new Font("宋体", Font.BOLD, 14);
		Font promptFont = new Font("宋体", Font.PLAIN, 9);

		FontMetrics fm = g2d.getFontMetrics();
		/*****************/
		/** 商户联 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("商户联(MERCHANT COPY)"), borderWidght,
				contentStartHeight += contentStartHeight / 2);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		/** 商户名称 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("商户名称(MERCHANT NAME)"), borderWidght,
				contentStartHeight += cols);
		String merName = getTagValue(messageMap, (short) 0xFF00, "an");
		int brNum = 15; // 控制文本长度，多少字换行。
		int contentRowNum = getContentRowNum(merName.length(), brNum);// 获得文本行数
		for (int i = 0, j = 1; i < contentRowNum; i++, j++)
		{
			if (j < contentRowNum)
				g2d.drawString(merName.substring(i * brNum, i * brNum + brNum),
						borderWidght, contentStartHeight += cols);
			else
				g2d.drawString(merName.substring(i * brNum, merName.length()),
						borderWidght, contentStartHeight += cols);
		}
		/** 商户英文名称 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getTagValue(messageMap, (short) 0xCF01, "an"),
				borderWidght, contentStartHeight += cols);

		/** 商户号 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("商户号(MER)  ") + curSignLs.getMerchantId(),
				borderWidght, contentStartHeight += cols);

		/** 终端号 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("终端号(TER)  ") + curSignLs.getTerminalId(),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		/** 发卡方 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF04, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("发卡方(ISSUER)  ")
							+ getTagValue(messageMap, (short) 0xFF04, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 卡号 **/
		if (!"".equals(curSignLs.getCardNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("卡号(CARD NO.)"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			String cardNo = curSignLs.getCardNo();

			// 卡号屏蔽按“前六后四”原则进行
			StringBuilder sb = new StringBuilder();
			int cardlen = cardNo.length();
			int lentmp = 4;

			sb.append(cardNo.substring(0, 6)).append(
					cardNo.substring(cardlen - 4, cardlen));
			for (int i = 0; i < cardlen - 10; ++i)
				sb.insert(6, '*');

			while (lentmp < cardlen)
			{
				sb.insert(lentmp, ' ');
				lentmp += 5;
				cardlen += 1;
			}

			g2d.drawString(sb.toString(), borderWidght, contentStartHeight +=
					cols);
		}

		/** 有效期 **/
		if (!"".equals(getExpDate(getTagValue(messageMap, (short) 0xFF05, "cn"))))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("有效期(EXP DATE):")
							+ getExpDate(getTagValue(messageMap,
									(short) 0xFF05, "cn")), borderWidght,
					contentStartHeight += cols);
		}

		/** 交易类型 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF01, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("交易类型(TXN TYPE):"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			g2d.drawString(getTagValue(messageMap, (short) 0xFF01, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 批次号 **/
		if (!"".equals(curSignLs.getBatchNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("批次号(BATCH NO.):") + curSignLs.getBatchNo(),
					borderWidght, contentStartHeight += cols);
		}

		/** 查询号 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF71, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("查询号(INVOICE NO.):")
							+ getTagValue(messageMap, (short) 0xFF71, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/** 流水号 **/
		if (!"".equals(curSignLs.getTraceNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("流水号(TRACE NO.):") + curSignLs.getTraceNo(),
					borderWidght, contentStartHeight += cols);
		}

		/** 授权码 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF07, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("授权码(AUTH CODE):")
							+ getTagValue(messageMap, (short) 0xFF07, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 交易日期时间 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF06, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("交易日期(DATE):")
							+ getTicketDate(getTagValue(messageMap,
									(short) 0xFF06, "cn")), borderWidght,
					contentStartHeight += cols);

			/** 交易时间 **/
			if (!"".equals(getTicketTime(getTagValue(messageMap,
					(short) 0xFF06, "cn"))))
			{
				g2d.setFont(nomarlFont);
				g2d.drawString(
						getGbkString("交易时间(TIME):")
								+ getTicketTime(getTagValue(messageMap,
										(short) 0xFF06, "cn")), borderWidght,
						contentStartHeight += cols);
			}
		}

		/** 原查询号 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF60, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("原查询号(OLD CHECK NO):")
							+ getTagValue(messageMap, (short) 0xFF60, "cn"),
					borderWidght, contentStartHeight += cols);
		}
		/** IC卡详单 **/
		/** 第一行 **/
		/* AID */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF22, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("AID:")
							+ getTagValue(messageMap, (short) 0xFF22, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/* TC */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF23, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("TC:")
							+ getTagValue(messageMap, (short) 0xFF23, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/* ATC */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF2a, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("ATC:")
							+ getTagValue(messageMap, (short) 0xFF2a, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/* CID */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF12, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("ATC:")
							+ getTagValue(messageMap, (short) 0xFF12, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/* TVR */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF28, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("TVR:")
							+ getTagValue(messageMap, (short) 0xFF28, "cn"),
					borderWidght, contentStartHeight += cols);
		}

		/* TSI */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF29, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("TSI:")
							+ getTagValue(messageMap, (short) 0xFF29, "cn"),
					borderWidght, contentStartHeight += cols);
		}
		/** APP LABEL **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF30, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("APP LABEL:"),
							getTagValue(messageMap, (short) 0xFF30, "an")),
					borderWidght, contentStartHeight += cols);
		}
		/* DCC汇率 */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF13, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("FX RATE*:")
							+ getTagValue(messageMap, (short) 0xCF13, "an"),
					borderWidght, contentStartHeight += cols);
		}
		/* MARK[X] TRANSCATION CURRENCY */
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("MARK[X] TRANSCATION CURRENCY"),
				borderWidght, contentStartHeight += cols);
		/* [ ]RMB AMOUNT HKD AMOUNT[ ] */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF15, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("[ ]RMB AMOUNT"),
							getTagValue(messageMap, (short) 0xCF15, "an")
									+ getGbkString(" AMOUNT[ ]")),
					borderWidght, contentStartHeight += cols);
		}
		/* DCC金额转换 */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF16, "an"))
				&& !"".equals(getTagValue(messageMap, (short) 0xCF17, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(
							getTagValue(messageMap, (short) 0xCF16, "an"),
							getTagValue(messageMap, (short) 0xCF17, "an")),
					borderWidght, contentStartHeight += cols);
		}
		/* 持卡人姓名 */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF18, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("持卡人姓名(CARDHOLDER NAME):"),
					borderWidght, contentStartHeight += cols);
			g2d.drawString(getTagValue(messageMap, (short) 0xCF18, "an"),
					borderWidght, contentStartHeight += cols);
		}
		/** 持卡人签名 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("持卡人签名(CARDHOLDER SIGNATURE)"),
				borderWidght, contentStartHeight += cols);

		/** 小票签名 **/
		g2d.drawImage(signPic, 0, contentStartHeight += cols, signWidth,
				signHeight, null);

		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols * 9);
		/** 最下方提示 **/
		g2d.setFont(promptFont);
		g2d.drawString(getGbkString(" THIS RECEIPT COMPLIES WITH VISA"),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString(" RULES AND THE SERVICE IS PROVIDED BY"),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString(" SERVICE PROVIDER. I'VE BEEN OFFERED"),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString(" CHOICE OF CURRENCIES INCLUDING RMB."),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString(" *INCL. FOUR PT. FIVE ZERO"),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(getGbkString(" PERCENT OVER WHOLESALE RATE."),
				borderWidght, contentStartHeight += cols);
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		g2d.dispose();
	}

	// 返回两端对齐字符串
	private String getAlignString(String label, String value)
	{
		int with = 29;
		StringBuilder sbt = new StringBuilder();
		sbt.append(label).append(value);

		int labelen = label.length();
		int inslen = with - labelen - value.length();

		for (int i = 0; i < inslen; i++)
		{
			sbt.insert(labelen, ' ');
		}

		return sbt.toString();
	}

	@RequestMapping
	private void getDccMasterTicket(Map<Short, byte[]> messageMap,
			Graphics2D g2d, String signFilePath,CurSignLs curSignLs) throws IOException
	{
		/*****************/
		File signFile = new File(signFilePath);
		Image signPic = ImageIO.read(signFile);

		// 页面宽度
		int signWidth = signPic.getWidth(null);
		int signHeight = signPic.getHeight(null);

		// 正文部分总高度
		int pageContentHeight = 1000;
		// 正文和文本边框宽度
		int borderWidght = 4;
		// 正文起始行高度
		int contentStartHeight = 120;
		// 列间距
		int cols = 17;

		Font nomarlFont = new Font("宋体", Font.PLAIN, 12);
		Font boldFont = new Font("宋体", Font.BOLD, 14);
		Font promptFont = new Font("宋体", Font.PLAIN, 8);

		FontMetrics fm = g2d.getFontMetrics();

		/*****************/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += contentStartHeight / 2);
		/** 商户名称 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("商户名称(MERCHANT NAME)"), borderWidght,
				contentStartHeight += cols);
		String merName = getTagValue(messageMap, (short) 0xFF00, "an");
		// 控制文本长度，多少字换行。
		int brNum = 15;
		// 获得文本行数
		int contentRowNum = getContentRowNum(merName.length(), brNum);

		for (int i = 0, j = 1; i < contentRowNum; i++, j++)
		{
			if (j < contentRowNum)
				g2d.drawString(merName.substring(i * brNum, i * brNum + brNum),
						borderWidght, contentStartHeight += cols);
			else
				g2d.drawString(merName.substring(i * brNum, merName.length()),
						borderWidght, contentStartHeight += cols);
		}
		/** 商户英文名称 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getTagValue(messageMap, (short) 0xCF01, "an"),
				borderWidght, contentStartHeight += cols);

		/** 商户号 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("商户编号(MERCHANT ID): "), borderWidght,
				contentStartHeight += cols);
		g2d.drawString(curSignLs.getMerchantId(), borderWidght,
				contentStartHeight += cols);
		/** 终端号 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("终端机号(TERMINAL ID): "), borderWidght,
				contentStartHeight += cols);
		g2d.drawString(curSignLs.getTerminalId(), borderWidght,
				contentStartHeight += cols);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		/** 卡别 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF04, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("卡别(CARD TYPE): "),
							getTagValue(messageMap, (short) 0xFF04, "an")),
					borderWidght, contentStartHeight += cols);
		}

		/** 卡号 **/
		if (!"".equals(curSignLs.getCardNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("卡号(CARD NO.)"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			String cardNo = curSignLs.getCardNo();

			// 卡号屏蔽按“前六后四”原则进行
			StringBuilder sb = new StringBuilder();
			int cardlen = cardNo.length();
			int lentmp = 4;

			sb.append(cardNo.substring(0, 6)).append(
					cardNo.substring(cardlen - 4, cardlen));
			for (int i = 0; i < cardlen - 10; ++i)
				sb.insert(6, '*');

			while (lentmp < cardlen)
			{
				sb.insert(lentmp, ' ');
				lentmp += 5;
				cardlen += 1;
			}

			g2d.drawString(sb.toString(), borderWidght, contentStartHeight +=
					cols);
		}

		/** 交易类型 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF01, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("交易类型(TRANS. TYPE):"), borderWidght,
					contentStartHeight += cols);
			g2d.setFont(boldFont);
			g2d.drawString(getTagValue(messageMap, (short) 0xFF01, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 有效期 **/
		if (!"".equals(getExpDate(getTagValue(messageMap, (short) 0xFF05, "cn"))))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(
							getGbkString("有效期(Expiry):"),
							getExpDate(getTagValue(messageMap, (short) 0xFF05,
									"cn"))), borderWidght, contentStartHeight +=
							cols);
		}

		/** 批次号 **/
		if (!"".equals(curSignLs.getBatchNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("批次号(BATCH NO.):"),
							curSignLs.getBatchNo()), borderWidght,
					contentStartHeight += cols);
		}

		/** 查询号 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF71, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("票据号(INVOICE NO.):"),
							getTagValue(messageMap, (short) 0xFF71, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/** 流水号 **/
		if (!"".equals(curSignLs.getTraceNo()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("流水号(TRACE NO.):"),
							curSignLs.getTraceNo()), borderWidght,
					contentStartHeight += cols);
		}

		/** 交易日期 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF06, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("交易日期(DATE):"), borderWidght,
					contentStartHeight += cols);
			g2d.drawString(
					getTicketDate(getTagValue(messageMap, (short) 0xFF06, "cn")),
					borderWidght, contentStartHeight += cols);

			/** 交易时间 **/
			g2d.drawString(getGbkString("交易时间(TIME):"), borderWidght,
					contentStartHeight += cols);
			g2d.drawString(
					getTicketTime(getTagValue(messageMap, (short) 0xFF06, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/** 授权码 **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF07, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("授权号(AUTH CODE):"),
							getTagValue(messageMap, (short) 0xFF07, "an")),
					borderWidght, contentStartHeight += cols);
		}

		/** 参考号 **/
		if (!"".equals(curSignLs.getTranRrn()))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("参考号(REF NO.):"),
							curSignLs.getTranRrn()), borderWidght,
					contentStartHeight += cols);
		}

		/** IC卡详单 **/
		/** 第一行 **/
		/* AID */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF22, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("AID:"),
							getTagValue(messageMap, (short) 0xFF22, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/* TC */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF23, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("TC:"),
							getTagValue(messageMap, (short) 0xFF23, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/* ATC */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF2a, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("ATC:"),
							getTagValue(messageMap, (short) 0xFF2a, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/* CID */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF12, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("ATC:"),
							getTagValue(messageMap, (short) 0xFF12, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/* TVR */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF28, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("TVR:"),
							getTagValue(messageMap, (short) 0xFF28, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/* TSI */
		if (!"".equals(getTagValue(messageMap, (short) 0xFF29, "cn")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("TSI:"),
							getTagValue(messageMap, (short) 0xFF29, "cn")),
					borderWidght, contentStartHeight += cols);
		}

		/** APP LABEL **/
		if (!"".equals(getTagValue(messageMap, (short) 0xFF30, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("APP LABEL:"),
							getTagValue(messageMap, (short) 0xFF30, "an")),
					borderWidght, contentStartHeight += cols);
		}

		/* DCC汇率 */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF13, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getGbkString("FX RATE*:")
							+ getTagValue(messageMap, (short) 0xCF13, "an"),
					borderWidght, contentStartHeight += cols);
		}
		/* [ ]RMB AMOUNT HKD AMOUNT[ ] */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF15, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(getGbkString("[ ]RMB AMOUNT"),
							getTagValue(messageMap, (short) 0xCF15, "an")
									+ getGbkString(" AMOUNT[ ]")),
					borderWidght, contentStartHeight += cols);
		}
		/* DCC金额转换 */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF16, "an"))
				&& !"".equals(getTagValue(messageMap, (short) 0xCF16, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(
					getAlignString(
							getTagValue(messageMap, (short) 0xCF16, "an"),
							getTagValue(messageMap, (short) 0xCF17, "an")),
					borderWidght, contentStartHeight += cols);
		}

		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		/* 持卡人姓名 */
		if (!"".equals(getTagValue(messageMap, (short) 0xCF18, "an")))
		{
			g2d.setFont(nomarlFont);
			g2d.drawString(getGbkString("持卡人姓名(CARDHOLDER NAME):"),
					borderWidght, contentStartHeight += cols);
			g2d.drawString(getTagValue(messageMap, (short) 0xCF18, "an"),
					borderWidght, contentStartHeight += cols);
		}

		/** 持卡人签名 **/
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("持卡人签名(CARDHOLDER SIGNATURE)"),
				borderWidght, contentStartHeight += cols);
		/** 小票签名 **/
		g2d.drawImage(signPic, 0, contentStartHeight += cols, signWidth,
				signHeight, null);

		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols * 9);
		/** 最下方提示 **/
		g2d.setFont(promptFont);
		g2d.drawString(
				getGbkString(" I DECLARE THAT I HAVE BEEN OFFERED A CHOICE OF"),
				borderWidght, contentStartHeight += cols);
		g2d.drawString(
				getGbkString(" PAYMENT CURRENCIES AND MY CHOICE IS FINAL."),
				borderWidght, contentStartHeight += cols);
		g2d.setFont(nomarlFont);
		g2d.drawString(getGbkString("------------------------------"),
				borderWidght, contentStartHeight += cols);

		g2d.dispose();
	}

	@RequestMapping
	public void getTicket(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		//System.out.println("被调用");
		String tranId = request.getParameter("tranId");
		CurSignLs curSignLs = (CurSignLs) curSignLsManager.getById(tranId);
		 String filePath = ConfigParamUtil.getProperty("filepath");
		// System.out.println("filePath"+filePath);
		String fileFullPath =
				ConfigParamUtil.getProperty("filepath") + File.separator
						+ curSignLs.getLocalSysDate() + File.separator
						+ curSignLs.getMerchantId() + File.separator
						+ curSignLs.getTerminalId() + File.separator;
		String signFilePath = fileFullPath + curSignLs.getSignFlName() + ".jpg";
		String ticketFilePath = fileFullPath + curSignLs.getTicketFlName();

		//LOG.error("TicketFilePath:" + ticketFilePath);

		Map<Short, byte[]> messageMap = getSignFileContent(ticketFilePath);

		int pageContentHeight = 1000;// 正文部分总高度
		int borderWidght = 4;// 正文和文本边框宽度
		int contentStartHeight = 120;// 正文起始行高度
		/***********
		 * int pageContentHeight = 800;// 正文部分总高度 int borderWidght =
		 * 4;//正文和文本边框宽度 int contentStartHeight = 120;// 正文起始行高度 int cols =
		 * 17;//列间距
		 * 
		 * Font nomarlFont = new Font("宋体", Font.PLAIN, 12); Font boldFont = new
		 * Font("宋体", Font.BOLD, 14); Font promptFont = new
		 * Font("宋体",Font.PLAIN, 9);
		 **********/

		File signFile = new File(signFilePath);
		File logoFile =
				new File(request.getRealPath("")
						+ "/commons/chinabanklogo.jpg");
		Image signPic = ImageIO.read(signFile);
		int signWidth = signPic.getWidth(null);
		int signHeight = signPic.getHeight(null);

		Image logoPic = ImageIO.read(logoFile);

		BufferedImage image =
				new BufferedImage(signWidth, signHeight + pageContentHeight,
						BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setBackground(Color.WHITE);
		g2d.clearRect(0, 0, signWidth, signHeight + pageContentHeight);//

		// FontMetrics fm = g2d.getFontMetrics();
		g2d.setPaint(Color.BLACK);

		/** 小票logo **/
		g2d.drawImage(logoPic, borderWidght, contentStartHeight,
				logoPic.getWidth(null) / 2, logoPic.getHeight(null) / 2, null);
		/** 小票正文 **/
		/** DCC交易需要有不同的打印显示 **/
		if ("01".equals(getTagValue(messageMap, (short) 0xCF19, "cn")))
		{
			/* DCC交易VISA卡 */
			getDccVisaTicket(messageMap, g2d, signFilePath,curSignLs);
		}
		else if ("02".equals(getTagValue(messageMap, (short) 0xCF19, "cn")))
		{
			/* DCC交易MASTER卡 */
			getDccMasterTicket(messageMap, g2d, signFilePath,curSignLs);
		}
		else
		{
			getNomalTicket(messageMap, g2d, signFilePath,curSignLs);
		}

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = null;
		try
		{
			imageOut = ImageIO.createImageOutputStream(output);
			ImageIO.write(image, "JPG", imageOut);
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (imageOut != null)
				{
					imageOut.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		response.setContentType("image/jpeg");
		response.setCharacterEncoding("GBK");
		String filename = "out.jpg";// 默认保存的文件名
		response.setHeader("Content-Disposition",
				"attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
		response.getOutputStream().write(output.toByteArray());

	}


	private Map<Short, byte[]> getSignFileContent(String ticketFileName)
	{

		File f = new File(ticketFileName);
		Map<Short, byte[]> map = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		try
		{
			fis = new FileInputStream(f);
			map = new HashMap<Short, byte[]>();
			dis = new DataInputStream(fis);

			while (dis.available() != 0)
			{
				Short key = new Short(dis.readShort());
				byte len = dis.readByte();
				byte[] value = new byte[len];
				dis.read(value);
				map.put(key, value);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				fis.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				dis.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return map;
	}

	private String getTagValue(Map<Short, byte[]> paramMap, Short tagNum,
			String codeType) throws UnsupportedEncodingException
	{
		byte[] value = paramMap.get(tagNum);
		if (value == null || value.length == 0)
			return "";
		else
		{
			if (codeType.equals("an"))
				return new String(value, bm);
			else if (codeType.equals("cn"))
				return bcd2Str(value);
			else if (codeType.equals("b"))
				return BinaryToHexString(value);
		}
		return "";
	}

	private String bcd2Str(byte[] bytes)
	{
		char temp[] = new char[bytes.length * 2], val;

		for (int i = 0; i < bytes.length; i++)
		{
			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

			val = (char) (bytes[i] & 0x0f);
			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
		}
		return new String(temp);
	}

	/**
	 * 
	 * @param bytes
	 * @return 将二进制转换为十六进制字符输出
	 */
	public static String BinaryToHexString(byte[] bytes)
	{
		String hexStr = "0123456789ABCDEF";
		String result = "";
		String hex = "";
		for (int i = 0; i < bytes.length; i++)
		{
			// 字节高4位
			hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
			// 字节低4位
			hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
			result += hex + "";
		}
		return result.trim();
	}

	private int getContentRowNum(int contentLength, int brLength)
	{
		int rowNum = 0;
		int result = contentLength % brLength;
		if (result == 0)
			rowNum = contentLength / brLength;
		else
			rowNum = contentLength / brLength + 1;
		return rowNum;
	}

	private String getGbkString(String content)
			throws UnsupportedEncodingException
	{
		return new String(content.getBytes(), bm);
	}

	/** 查看对象 */
	@RequestMapping
	public String show(Model model, @RequestParam("id") String id) {
		//System.out.println("ID是："+id);
		//System.out.println("model是："+curSignLsManager.getById(id));
		model.addAttribute("model", curSignLsManager.getById(id));
		return "/ssp_pages/CurSignLs/show";
	}
	

	/** 进入新增页面 */
	@RequestMapping
	public String create()
	{
		return "/ssp_pages/CurSignLs/create";
	}

	/** 保存新增对象 */
	@RequestMapping
	public String save(@ModelAttribute("model") CurSignLs curSignLs)
	{
		curSignLsManager.insert(curSignLs);
			return "redirect:list.do";
	}

	/** 进入更新页面 */
	@RequestMapping
	public String edit(Model model, @RequestParam("id") String id) {
		model.addAttribute("model", curSignLsManager.getById(id));
		return "/ssp_pages/CurSignLs/edit";
	}
	

	/** 保存更新对象 */
	@RequestMapping
	public String update(@ModelAttribute("model") CurSignLs curSignLs) {
		curSignLsManager.update(curSignLs);
		return "redirect:list.do";
	}
	

	/** 删除对象 */
	/** 进入更新页面 */
	@RequestMapping
	public String delete(@RequestParam("id") String id) {
		curSignLsManager.delete(id);
		return "redirect:list.do";
	}

	@RequestMapping
	public void isExitByMerchantId(Model model,@ModelAttribute("query") CurSignLsQuery query,HttpServletRequest request,HttpServletResponse response,
			@RequestParam("merchantId") String merchantId) throws IOException
	{
		
		Boolean bo = false;
		String merId = request.getParameter("merchantId");
		query.setMerchantId(merId);
		Page page = curSignLsManager.queryPage(query);
		if (page.getResult().size() != 0)
		{
			bo = true;
		}
		response.getWriter().print(bo);
	}

	

	/** 小票交易日期格式转换 **/
	public String getTicketDate(String LocalSysDate)
	{
		SimpleDateFormat stringToDate = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateToString = new SimpleDateFormat("yyyy/MM/dd");
		String result = null;
		;
		try
		{
			Date date = stringToDate.parse(LocalSysDate.substring(0, 8));
			result = dateToString.format(date);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/** 小票交易时间转换 **/
	public String getTicketTime(String LocalSysTime)
	{
		SimpleDateFormat stringToTime = new SimpleDateFormat("HHmmss");
		SimpleDateFormat timeToString = new SimpleDateFormat("HH:mm:ss");
		String result = null;
		try
		{
			Date date = stringToTime.parse(LocalSysTime.substring(8));
			result = timeToString.format(date);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		return result;
	}

	/** 小票有效期日期转换 **/
	public String getExpDate(String expDate)
	{
		SimpleDateFormat stringToDate = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat dateToString = new SimpleDateFormat("yyyy/MM");
		String result = null;
		try
		{
			//System.out.println("卡有效期："+expDate);
			Date date = stringToDate.parse("20" + expDate);
			//System.out.println("转换后的日期是："+expDate);
			result = dateToString.format(date);
		} catch (ParseException e)
		{
			System.out.println("这出现异常");
			e.printStackTrace();
		}
		return result;
	}
}
