package asia.lhweb.furn.utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2023/9/24
 */
public class MBGUtil {
    public static void main(String[] args)throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //指定配置文件 文件直接放在项目下
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);

        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("逆向生成 OK");
    }
}
