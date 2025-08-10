plugins {
    id("java")
}

group = "net.weesli.veldoracore"

dependencies{
    compileOnly("io.papermc.paper:paper-api:1.21.4-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}