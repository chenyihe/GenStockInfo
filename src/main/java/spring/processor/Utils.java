package spring.processor;

import spring.domain.Stock;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public String getStockInfo(String path) throws MalformedURLException {
        BufferedReader in = null;
        StringBuffer result = null;
        URL url = new URL(path);
        System.out.println(url);
        try {
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            result = new StringBuffer();
            //从网页上获取stock信息指定编码为GBK，否则乱码
            in = new BufferedReader(new InputStreamReader(
                    inputStream,"GBK"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }

    /**
     **因为无法获得具体的股票代码，通过循环获取，200个号码为一组.根据上证、深证、创业板调整
     */
    public List<String> getPath(){
        String str = "http://hq.sinajs.cn/list=";
        List<String> path = new ArrayList<String>();
        for(int i = 600000;i <= 602000;i++){
            str += "sh"+i+",";
            if(i % 50 == 0){
                path.add(str);
                str="http://hq.sinajs.cn/list=";
            }
        }
//        for(int j = 300000;j <= 300800;j++){
//            str += "sz"+j+",";
//            if(j % 50 == 0){
//                path.add(str);
//                str="http://hq.sinajs.cn/list=";
//            }
//        }
//
//        for(int m = 1; m <= 3000; m++){
//            if(m < 1000 && m >= 100){
//                str += "sz000"+m+",";
//            }
//
//            if(m >= 1000){
//                str += "sz00"+m+",";
//            }
//
//            if(m < 100 && m >= 10){
//                str += "sz0000"+m+",";
//            }
//
//            if(m < 10){
//                str += "sz00000" + m + ",";
//            }
//
//            if(m % 50 == 0){
//                path.add(str);
//                str = "http://hq.sinajs.cn/list=";
//            }
//        }
        return path;
    }


    /**
     * 数据预处理
     */
    public List<Stock> genStock(String stockdata) throws UnsupportedEncodingException {

        List<Stock> stocklist = new ArrayList<Stock>();
        String[] stocks = stockdata.split(";");
        for(String str : stocks) {
            String[] tmpdata1 = str.split("\"");
            if (tmpdata1.length == 1) {
                continue;
            }
            System.out.println(tmpdata1);
            String[] tmpdata2 = tmpdata1[1].split(",");
            Stock stock = new Stock();
            stock.setStockCode(tmpdata1[0].substring(13,19));
            System.out.println(tmpdata2[0]);
            stock.setStockName(new String(tmpdata2[0].getBytes("GBK"),"GBK"));
            stock.setOpenPrice(Double.parseDouble(tmpdata2[1]));
            stock.setLastPrice(Double.parseDouble(tmpdata2[2]));
            stock.setCurrPrice(Double.parseDouble(tmpdata2[3]));
            stock.setHighPrice(Double.parseDouble(tmpdata2[4]));
            stock.setLowPrice(Double.parseDouble(tmpdata2[5]));
            stock.setBuyPrice(Double.parseDouble(tmpdata2[6]));
            stock.setSalePrice(Double.parseDouble(tmpdata2[7]));
            stock.setDealStock(Integer.parseInt(tmpdata2[8]));
            stock.setDealFee(Double.parseDouble(tmpdata2[9]));
            stock.setBuy1Total(Integer.parseInt(tmpdata2[10]));
            stock.setBuy1Price(Double.parseDouble(tmpdata2[11]));
            stock.setBuy2Total(Integer.parseInt(tmpdata2[12]));
            stock.setBuy2Price(Double.parseDouble(tmpdata2[13]));
            stock.setBuy3Total(Integer.parseInt(tmpdata2[14]));
            stock.setBuy3Price(Double.parseDouble(tmpdata2[15]));
            stock.setBuy4Total(Integer.parseInt(tmpdata2[16]));
            stock.setBuy4Price(Double.parseDouble(tmpdata2[17]));
            stock.setBuy5Total(Integer.parseInt(tmpdata2[18]));
            stock.setBuy5Price(Double.parseDouble(tmpdata2[19]));
            stock.setSale1Total(Integer.parseInt(tmpdata2[20]));
            stock.setSale1Price(Double.parseDouble(tmpdata2[21]));
            stock.setSale2Total(Integer.parseInt(tmpdata2[22]));
            stock.setSale2Price(Double.parseDouble(tmpdata2[23]));
            stock.setSale3Total(Integer.parseInt(tmpdata2[24]));
            stock.setSale3Price(Double.parseDouble(tmpdata2[25]));
            stock.setSale4Total(Integer.parseInt(tmpdata2[26]));
            stock.setSale4Price(Double.parseDouble(tmpdata2[27]));
            stock.setSale5Total(Integer.parseInt(tmpdata2[28]));
            stock.setSale5Price(Double.parseDouble(tmpdata2[29]));
            stock.setDate(tmpdata2[30]);
            stock.setTime(tmpdata2[31]);
            stocklist.add(stock);
        }
        return stocklist;
    }


}
