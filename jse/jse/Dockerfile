#FROM payara/server-full
#COPY core/target/core.war $DEPLOY_DIR


FROM payara/micro:5.183
ADD jse/target/dac-jse-jar-with-dependencies.jar $PAYARA_PATH/
ENTRYPOINT ["java", "-jar", "dac-jse-jar-with-dependencies.jar"]
