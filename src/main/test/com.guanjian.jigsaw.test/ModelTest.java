package com.guanjian.jigsaw.test;

public class ModelTest {

//   public static void main(String[] args) {
//        GraphicsFactory.Builder gfBuilder = new GraphicsFactory.Builder(690,930);
//        GraphicsFactory gf = gfBuilder.build();
//
//        List<Layer> layerList = new ArrayList<Layer>();
//        //商品图片1
//        String goods1 = "C:\\Users\\guanjian\\Desktop\\timg.jpg";
//        Photo goodsImage1 = new Photo(new File(goods1));
//        Element goodsele1 = new Element.Builder()
//                .height(416)
//                .width(416)
//                .x(30)
//                .y(30)
//                .build();
//        //商品图片2
//        String goods2 = "C:\\Users\\guanjian\\Desktop\\timg.jpg";
//        Photo goodsImage2 = new Photo(new File(goods2));
//        Element goodsele2 = new Element.Builder()
//                .height(203)
//                .width(203)
//                .x(456)
//                .y(30)
//                .build();
//
//        //商品图片3
//        String goods3 = "C:\\Users\\guanjian\\Desktop\\timg.jpg";
//        Photo goodsImage3 = new Photo(new File(goods3));
//        Element goodsele3 = new Element.Builder()
//                .height(203)
//                .width(203)
//                .x(456)
//                .y(242)
//                .build();
//        //商品图片4
//        String goods4 = "C:\\Users\\guanjian\\Desktop\\timg.jpg";
//        Photo goodsImage4 = new Photo(new File(goods4));
//        Element goodsele4 = new Element.Builder()
//                .height(203)
//                .width(203)
//                .x(30)
//                .y(456)
//                .build();
//        //商品图片5
//        String goods5 = "C:\\Users\\guanjian\\Desktop\\timg.jpg";
//        Photo goodsImage5 = new Photo(new File(goods5));
//        Element goodsele5 = new Element.Builder()
//                .height(203)
//                .width(203)
//                .x(243)
//                .y(456)
//                .build();
//
//        //商品图片6
//        String goods6 = "C:\\Users\\guanjian\\Desktop\\timg.jpg";
//        Photo goodsImage6 = new Photo(new File(goods6));
//        Element goodsele6 = new Element.Builder()
//                .height(203)
//                .width(203)
//                .x(456)
//                .y(456)
//                .build();
//
//        //二维码
//        File file2 = new File("C:\\Users\\guanjian\\Desktop\\timg.jpg");
//        Photo qrCode = new Photo(file2);
//        Element e2 = new Element.Builder()
//                .height(190)
//                .width(190)
//                .x(470)
//                .y(700)
//                .build();
//
//        //商品名称
//        AttributedString as = new AttributedString("浪味仙");
//        as.addAttribute(TextAttribute.FONT, FontUtil.getPingFangRegular(28F));
//
//        Text goodsName = new Text.Builder()
//                .color(new Color(34, 34, 34))
//                .attributedString(as)
//                .build();
//        Element e3 = new Element.Builder()
//                .x(30)
//                .y(700)
//                .build();
//
//        //商品价格
//        AttributedString as2 = new AttributedString("惊喜价：￥68.00");
//        as2.addAttribute(TextAttribute.FONT, FontUtil.getPingFangRegular(24F));
//
//        Text goodsPrice = new Text.Builder()
//                .color(new Color(153, 153, 153))
//                .attributedString(as2)
//                .build();
//        Element e4 = new Element.Builder()
//                .x(30)
//                .y(800)
//                .build();
//
//        //商品特殊价文本
//        AttributedString as3 = new AttributedString("特惠价：");
//        as3.addAttribute(TextAttribute.FONT, FontUtil.getPingFangRegular(24F));
//
//        Text specialPrice = new Text.Builder()
//                .color(new Color(153, 153, 153))
//                .attributedString(as3)
//                .build();
//        Element e5 = new Element.Builder()
//                .x(30)
//                .y(850)
//                .build();
//
//        //商品特殊价数字
//        AttributedString as5 = new AttributedString("￥12.00");
//        as5.addAttribute(TextAttribute.FONT, FontUtil.getPingFangBold(26F));
//
//        Text spPriceNum = new Text.Builder()
//                .color(new Color(34, 34, 34))
//                .attributedString(as5)
//                .build();
//        Element e6 = new Element.Builder()
//                .x(167)
//                .y(845)
//                .build();
//
//        //拼购
//        AttributedString as6 = new AttributedString("2人拼");
//        as6.addAttribute(TextAttribute.FONT, FontUtil.getPingFangBold(22F));
//
//        Text pingou = new Text.Builder()
//                .color(new Color(59, 188, 133))
//                .attributedString(as6)
//                .build();
//        Element e7 = new Element.Builder()
//                .x(309)
//                .y(851)
//                .build();
//
//        Layer goodsImage1Layer = new Layer(goodsImage1, goodsele1);
//        Layer goodsImage2Layer = new Layer(goodsImage2, goodsele2);
//        Layer goodsImage3Layer = new Layer(goodsImage3, goodsele3);
//        Layer goodsImage4Layer = new Layer(goodsImage4, goodsele4);
//        Layer goodsImage5Layer = new Layer(goodsImage5, goodsele5);
//        Layer goodsImage6Layer = new Layer(goodsImage6, goodsele6);
//        Layer qrCodeLayer = new Layer(qrCode, e2);
//        Layer goodsNameLayer = new Layer(goodsName, e3);
//        Layer goodsPriceLayer = new Layer(goodsPrice, e4);
//        Layer specialPriceLayer = new Layer(specialPrice, e5);
//        Layer spPriceNumLayer = new Layer(spPriceNum, e6);
//        Layer pinggouLayer = new Layer(pingou, e7);
//
//        layerList.add(goodsImage1Layer);
//        layerList.add(goodsImage2Layer);
//        layerList.add(goodsImage3Layer);
//        layerList.add(goodsImage4Layer);
//        layerList.add(goodsImage5Layer);
//        layerList.add(goodsImage6Layer);
//        layerList.add(qrCodeLayer);
//        layerList.add(goodsNameLayer);
//        layerList.add(goodsPriceLayer);
//        layerList.add(specialPriceLayer);
//        layerList.add(spPriceNumLayer);
//        layerList.add(pinggouLayer);
//        long start = System.currentTimeMillis();
//        gf.produce(layerList);
//        long end = System.currentTimeMillis();
//        System.out.println(String.format("消耗时间 %s ms", end - start));
//    }

}