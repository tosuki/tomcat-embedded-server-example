plugins {
    id("java")
}

group = "com.tosuki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // tomcat embeded http server xD
    implementation("org.apache.tomcat.embed:tomcat-embed-core:11.0.3")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}