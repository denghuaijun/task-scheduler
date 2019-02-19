package com.ct.core.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.FormBody.Builder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：libin
 * @ Date       ：Created in 19:09 2018/9/13
 * @ Description：${description}
 * @ Modified By：Hessian序列化工具类
 * @Version: $version$
 */
@Slf4j
public class HttpUtil {

	private static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS).build();
	public static final MediaType MEDIA_TYPE_FORM = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
	public static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
	public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
	public static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain; charset=utf-8");

	public static String get(String url) throws IOException {
		log.info("要访问的url是:{}", url);
		Request request = new Request.Builder().url(url).build();
		return execute(request);
	}

	public String post(String url) throws IOException {
		log.info("要访问的url是:{}", url);
		RequestBody body = RequestBody.create(MEDIA_TYPE_MARKDOWN, "");
		Request request = new Request.Builder().url(url).post(body).build();
		return execute(request);
	}

	public String post(String data, String url) throws IOException {
		log.info("要访问的url是：{},post方式提交的json为：{}", url, data);
		RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, data);
		Request request = new Request.Builder().url(url).post(body).build();
		return execute(request);
	}

	public String postText(String data, String url) throws IOException {
		log.info("要访问的url是：{},post方式提交的Text为：{}", url, data);
		RequestBody body = RequestBody.create(MEDIA_TYPE_TEXT, data);
		Request request = new Request.Builder().url(url).post(body).build();
		return execute(request);
	}


	/* 车险上传图片，图片内容为byte数组，data过大不做记录 */
	public String postWithoutParamLog(String data, String url) throws IOException {
		log.info("要访问的url是：{}", url);
		RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, data);
		Request request = new Request.Builder().url(url).post(body).build();
		return execute(request);
	}

	private static String execute(Request request) throws IOException {
		Response response = client.newCall(request).execute();
		if (!response.isSuccessful()) {
			throw new IOException("error code:" + response);
		}
		ResponseBody responseBody = response.body();
		String result = responseBody.string();
		log.info("调用接口返回结果为：{}", result);
		responseBody.close();
		return result;
	}


	/**
	 * post提交表单
	 * 
	 * @param map
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String postForm(Map<String, String> map, String url) throws Exception {
		log.info("要访问的url是：{},表单提交的参数为：{}", url, map);
		// RequestBody body = FormBody.create(MEDIA_TYPE_FORM, map.toString());
		Builder builder = new FormBody.Builder();
		// 模拟表单
		for (String key : map.keySet()) {
			builder.add(key, map.get(key));
		}
		RequestBody requestBody = builder.build();
		Request request = new Request.Builder().url(url).post(requestBody).build();
		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("无法解析的code===========" + response);
		ResponseBody responseBody = response.body();
		String result = responseBody.string();
		log.info("调用接口返回结果为：{}", result);
		responseBody.close();
		return result;
	}

	public static byte[] postFormByte(Map<String, String> map, String url) throws Exception {
		log.info("要访问的url是：{},表单提交的参数为：{}", url, map);
		// RequestBody body = FormBody.create(MEDIA_TYPE_FORM, map.toString());
		Builder builder = new FormBody.Builder();
		// 模拟表单
		for (String key : map.keySet()) {
			builder.add(key, map.get(key));
		}
		RequestBody requestBody = builder.build();
		Request request = new Request.Builder().url(url).post(requestBody).build();
		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("无法解析的code===========" + response);
		ResponseBody responseBody = response.body();

		byte[] result = responseBody.bytes();
		log.info("调用接口返回结果为：{}", result);
		responseBody.close();
		return result;
	}

	public static byte[] postRequestBody(byte[] content, String url) throws Exception {
		RequestBody requestBody = FormBody.create(MEDIA_TYPE_JSON, content);
		Request request = new Request.Builder().url(url).post(requestBody).build();
		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException(" error message " + response);
		ResponseBody responseBody = response.body();
		byte[] result = responseBody.bytes();
		responseBody.close();
		return result;
	}

	/**
	 * post提交表单
	 * 
	 * @param requestBody
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String postForm(RequestBody requestBody, String url) throws Exception {
		Request request = new Request.Builder().url(url).post(requestBody).build();
		Response response = client.newCall(request).execute();
		if (!response.isSuccessful())
			throw new IOException("无法解析的code===========" + response);
		ResponseBody responseBody = response.body();
		String result = responseBody.string();
		log.info("调用接口返回结果为：{}", result);
		responseBody.close();
		return result;
	}

	public static final byte[] readBytes(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		int contentLen = request.getContentLength();
		InputStream is = request.getInputStream();
		if (contentLen > 0) {
			int readLen = 0;
			int readLengthThisTime = 0;
			byte[] message = new byte[contentLen];
			try {
				while (readLen != contentLen) {
					readLengthThisTime = is.read(message, readLen, contentLen - readLen);
					if (readLengthThisTime == -1) {
						break;
					}
					readLen += readLengthThisTime;
				}
				return message;
			} catch (IOException e) {
				throw e;
			}
		}
		return new byte[] {};
	}
}
