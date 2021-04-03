package com.woniu.annotations;
@Annotation(id = -1, name = "qwe")
@Annotation2({"qwe","asd","zxc"})
@Annotation3
public class AnnotationTest {
	@Annotation(id = 1, name = "sd")
	int pid;
	@Annotation(id = 2, name = "zx")
	String pname;
	@Annotation2({"123","456","789"})
	String code;
	@Annotation3
	String address;

}
