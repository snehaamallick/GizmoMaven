package form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

		private List<MultipartFile> crunchifyfiles;

		public List<MultipartFile> getFiles() {
			return crunchifyfiles;
		}

		public void setFiles(List<MultipartFile> files) {
			this.crunchifyfiles = files;
		}
	    
}
