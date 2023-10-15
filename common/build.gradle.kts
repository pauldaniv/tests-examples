val springBootVersion = "3.1.4"

//publishing {
//  repositories {
//    mavenLocal()
////    maven {
////      name = "GitHubPackages"
////      // change URLs to point to your repos, e.g. http://my.org/repo
////      // def releasesRepoUrl = "$buildDir/repos/releases"
////      // def snapshotsRepoUrl = "$buildDir/repos/snapshots"
////      // url = version.endsWith("SNAPSHOT") ? snapshotsRepoUrl : releasesRepoUrl
////
////      url = uri("https://maven.pkg.github.com/pauldaniv/test-examples")
////      credentials {
////        username = project.findProperty("gpr.usr") ?: System.getenv("USERNAME")
////        password = project.findProperty("gpr.key") ?: System.getenv("TOKEN")
////      }
////    }
//  }
//
//  publications {
//    gpr(MavenPublication) {
////        artifactId = "common"
////
////        from(components.java)
////      }
//
////    mavenJava(MavenPublication) {
////      from components.java
////      versionMapping {
////        usage("java-api") {
////          fromResolutionOf("runtimeClasspath")
////        }
////        usage("java-runtime") {
////          fromResolutionResult()
////        }
////      }
//      pom {
//        name = "Test-Examples common library"
//        description = "Just a test changed library between different services"
//        licenses {
//          license {
//            name = "The Apache License, Version 2.0"
//            url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
//          }
//        }
//        developers {
//          developer {
//            id = "pauldaniv"
//            name = "Paul Daniv"
//            email = "pauldaniv@github.com"
//          }
//        }
//        scm {
//          connection = "scm:git:git://github.com/pauludaniv/test-examples.git"
//          developerConnection = "scm:git:ssh://github.com/pauludaniv/test-examples.git"
//          url = "maybe one day"
//        }
//      }
//    }
//  }
//}

//signing {
//  sign publishing.publications.mavenJava
//}
//
//javadoc {
//  if (JavaVersion.current().isJava9Compatible()) {
//    options.addBooleanOption("html5", true)
//  }
//}

dependencies {
    implementation("org.springframework.boot:spring-boot-dependencies:${springBootVersion}")

    implementation("org.codehaus.groovy:groovy:3.0.7")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.modelmapper:modelmapper:3.0.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    implementation("io.springfox:springfox-swagger2:3.0.0")
    implementation("io.springfox:springfox-core:3.0.0")
    implementation("io.springfox:springfox-spi:3.0.0")
    implementation("org.springdoc:springdoc-openapi-ui:1.4.1")

    compileOnly("org.springframework.cloud:spring-cloud-starter-openfeign:2.1.0.RELEASE")

    api("org.postgresql:postgresql:42.2.27")
    runtimeOnly("com.h2database:h2:2.1.214")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
  imports { mavenBom("org.springframework.boot:spring-boot-dependencies:${springBootVersion}") }
}

//ext["library"] = true
