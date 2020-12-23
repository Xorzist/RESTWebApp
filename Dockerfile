FROM airhacks/glassfish
COPY ./target/RESTWebApp.war ${DEPLOYMENT_DIR}
