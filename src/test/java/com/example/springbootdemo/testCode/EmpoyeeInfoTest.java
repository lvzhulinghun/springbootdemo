/*
package com.example.springbootdemo.testCode;

public class EmpoyeeInfoTest {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        String keys [] = {"employeeId","employeeName","idCard","highestEdu","mobileNum","jobLevel","birthday","postAddress","postCode","email","groupName",
                "subGroupName","orgFinancialName","orgName","longPositionName","city","clanName","hireTime","companyCellphone","personalCellphone"};
        String fileName = "C:\\Users\\MTW\\Desktop\\employInfo.txt";
//    	BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
//    	byte b[]= new byte[1024];
//    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));

        int bh = 11070768;
        int increament = 5; //递增
        for(int i=bh;i<=(bh+increament);i++){
            RandomAccessFile ras = new RandomAccessFile(fileName, "rw");
            CloseableHttpClient build = HttpClientBuilder.create().build();
            String url = "http://uuqsit.cnsuning.com/uum-unify-query-web//uumEmployee?clientId=ewsms&clientKey=%5Di9cmpDB6DOp&employeeId="+i;
            HttpGet httpGet = new HttpGet(url);
            CloseableHttpResponse response = build.execute(httpGet);
            HttpEntity entity = response.getEntity();
            JSONObject parseObject = JSONObject.parseObject(EntityUtils.toString(entity));
            Object object = parseObject.get("data");
            if(object!=null){
                JSONObject oo = (JSONObject) object;
                StringBuilder info = new StringBuilder();
                for(String str : keys){
                    info.append(str+":"+oo.get(str) +"; ");
                }
                info.replace(info.lastIndexOf(";"), info.length(), "。");
                ras.seek(ras.length());
                ras.write(info.toString().getBytes("UTF-8"));
                ras.write("\r\n".getBytes());
                ras.write("\r\n".getBytes());
            }
            ras.close();
            build.close();
            response.close();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
*/
