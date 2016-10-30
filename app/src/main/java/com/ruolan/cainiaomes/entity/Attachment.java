package com.ruolan.cainiaomes.entity;

import com.google.gson.stream.JsonReader;
import com.ruolan.cainiaomes.net.AppException;

import java.io.IOException;
import java.io.Serializable;

public class Attachment extends BaseEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FILE_NAME = "file_name";
	public static final String FILE_TYPE = "file_type";
	public static final String FILE_URL = "file_url";
	public static final String FILE_PATH = "file_path";

	private String file_name;
	private String file_type;
	private String file_url;
	private String file_path;

	public enum AttachmentType {
		PNG("image/png", "png"), TIFF("image/tiff", "tiff"), GIF("image/gif", "gif"), JPG("image/jpg", "jpg"), JPEG("image/jpeg", "jpg"), TXT(
				"text/plain", "txt"), RTF("text/rtf", "rtf"), HTML("text/html", "html"), HTM("text/html", "htm"), XML("application/xml", "xml"), PDF(
				"application/pdf", "pdf"), DOC("application/msword", "doc"), XLS("application/vnd.ms-excel", "xls"), PPT(
				"application/vnd.ms-powerpoint", "ppt"), PPTX("application/vnd.openxmlformats-officedocument.presentationml.presentation", "pptx"), XLSX(
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx"), DOCX(
				"application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx"), MP4("video/mp4", "mp4"), AAC("audio/aac", "aac"), MSG(
				"application/vnd.ms-outlook", "msg"), ZIP("application/zip", "zip"), TIF("image/tiff", "tif"), DWG("application/acad", "dwg"), DWF(
				"drawing/x-dwf", "dwf"), DXF("image/vnd.dwg", "dxf"), MOV("video/quicktime", "mov"), M4V("video/x-m4v", "m4v"), THREEGP("video/3gpp",
				"3gp"), BMP("image/bmp", "bmp"), ICO("image/x-icon", "ico"), CUR("image/vnd.microsoft.icon", "cur"), XBM("image/x-xbitmap", "xbm"), MP3(
				"audio/mpeg3", "mp3");

		private String mimeType;
		private String extension;

		public String fetchMimeType() {
			return mimeType;
		}

		public String fetchExtension() {
			return extension;
		}

		AttachmentType(String mimeType, String extension) {
			this.mimeType = mimeType;
			this.extension = extension;
		}
	}

	public Attachment(String path) {
		this.file_name = path.substring(path.lastIndexOf("/") + 1);
		this.file_url = path;
		this.file_type = AttachmentType.valueOf(path.substring(path.lastIndexOf(".") + 1).toUpperCase()).fetchMimeType();
	}

	public Attachment() {

	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	@Override
	public void readFromJson(JsonReader reader) throws AppException {
		try {
			reader.beginObject();
			String node = null;
			while (reader.hasNext()) {
				node = reader.nextName();
				if (FILE_NAME.equals(node)) {
					file_name = reader.nextString();
				} else if (FILE_PATH.equals(node)) {
					file_path = reader.nextString();
				} else if (FILE_TYPE.equals(node)) {
					file_type = reader.nextString();
				} else if (FILE_URL.equals(node)) {
					file_url = reader.nextString();
				} else {
					reader.skipValue();
				}
			}
			reader.endObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
