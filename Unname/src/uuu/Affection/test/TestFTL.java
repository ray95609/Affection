/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uuu.Affection.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class TestFTL {

    public static void main(String[] args) throws Exception {
        File ftlDir = new File("ftl");

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(ftlDir);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> map = new HashMap<>();
        map.put("blogTitle", "Freemarker Template Demo");
        map.put("message", "歡迎");
//        List<URL> references = new ArrayList<>();
//        references.add(new URL("http://url1.com", "URL One"));

        Template template = cfg.getTemplate("blog-template.ftl");

        //Writer console = new OutputStreamWriter(System.out);
        //template.process(map, console);
        try(StringWriter stringWriter = new StringWriter();){
            template.process(map, stringWriter);
            System.out.println(stringWriter);
        }
    }
}
