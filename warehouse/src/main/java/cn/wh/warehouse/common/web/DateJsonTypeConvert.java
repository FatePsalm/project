package cn.wh.warehouse.common.web;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * springmvc���ص�json���У�
 * ��Date����תΪlong���ͣ�
 * ͨ������̳�JsonSerializer���Զ����ʽ��
 * ֮����ʵ�����Ӧ��date���͵��ֶε�
 * getter���������ע��
 * @JsonSerialize(using=DateJsonTypeConvert.class)
 * @author Admin
 */
public class DateJsonTypeConvert extends 
   JsonSerializer<Date> {
	//�������л��ַ���(����ת��Ϊjson��ʽ)
	@Override
	public void serialize(Date arg0, 
			JsonGenerator arg1,
			SerializerProvider arg2)
			throws IOException, 
			JsonProcessingException {
		//�Լ��������ڸ�ʽ
		SimpleDateFormat sdf=
		new SimpleDateFormat("yyyy-MM-dd");
		//��������json��ʽ���
		arg1.writeString(sdf.format(arg0));
	}
}
