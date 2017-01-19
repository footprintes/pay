import com.alibaba.fastjson.JSON;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>类说明</p>
 *
 * @author 张峰 zfvip_it@163.com
 * @createTime: 2017/1/19 9:42
 */
public class Test {

    public static void main(String[] args) throws Exception {

//        JAXBContext context = JAXBContext.newInstance(Department.class, Staff.class);    // 获取上下文对象
        JAXBContext context = JAXBContext.newInstance(Ceshi.class);    // 获取上下文对象
        Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象

        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进

        marshaller.marshal(getCeshi(), System.out);   // 打印到控制台

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        marshaller.marshal(getCeshi(), baos);
        String xmlObj = new String(baos.toByteArray());         // 生成XML字符串
        System.out.println(xmlObj);

        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<ceshi Aa=\"haha\" Bb=\"hbhb\"/>";
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Ceshi student = (Ceshi)unmarshaller.unmarshal(new StringReader(str));
        System.out.println(JSON.toJSON(student));
    }

    private static Ceshi getCeshi(){
        Ceshi ceshi = new Ceshi();
        ceshi.setAa("haha");
        ceshi.setBb("hbhb");
        return ceshi;
    }

    /**
     * 生成一个简单的Department对象
     *
     * @return
     */
    private static Department getSimpleDepartment() {
        List<Staff> staffs = new ArrayList<Staff>();

        Staff stf = new Staff();
        stf.setName("周杰伦");
        stf.setAge(30);
        stf.setSmoker(false);
        staffs.add(stf);
        stf.setName("周笔畅");
        stf.setAge(28);
        stf.setSmoker(false);
        staffs.add(stf);
        stf.setName("周星驰");
        stf.setAge(40);
        stf.setSmoker(true);
        staffs.add(stf);

        Department dept = new Department();
        dept.setName("娱乐圈");
        dept.setStaffs(staffs);

        return dept;
    }

    @XmlRootElement(name = "staff")
    static class Staff {

        private String name;    // 职员名称
        private int age;        // 职员年龄
        private boolean smoker; // 是否为烟民

        public String getName() {
            return name;
        }

        @XmlElement
        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @XmlElement
        public void setAge(int age) {
            this.age = age;
        }

        public boolean isSmoker() {
            return smoker;
        }

        @XmlAttribute
        public void setSmoker(boolean smoker) {
            this.smoker = smoker;
        }
    }

    @XmlRootElement(name = "department")
    static class Department {

        private String name;    //部门名称
        private List<Staff> staffs;           // 其实staff是单复同型，这里是加's'是为了区别staff

        public String getName() {
            return name;
        }

        @XmlAttribute
        public void setName(String name) {
            this.name = name;
        }

        public List<Staff> getStaffs() {
            return staffs;
        }

        @XmlElement(name = "staff")
        public void setStaffs(List<Staff> staffs) {
            this.staffs = staffs;
        }
    }

    @XmlRootElement(name = "ceshi")
    static class Ceshi{
        private String aa;
        private String bb;

        public String getAa() {
            return aa;
        }
        @XmlAttribute(name = "Aa")
        public void setAa(String aa) {
            this.aa = aa;
        }

        public String getBb() {
            return bb;
        }
        @XmlAttribute(name = "Bb")
        public void setBb(String bb) {
            this.bb = bb;
        }
    }
}
