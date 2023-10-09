echo "Build script started"

sh "Docker build -f api-gateway/Dockerfile -t e-commerce-backend-api-gateway-v2"
sh "Docker build -f authorization-service/Dockerfile -t e-commerce-backend-authorization-service-v2"
sh "Docker build -f inventory-service/Dockerfile -t e-commerce-backend-inventory-service-v2"
sh "Docker build -f order-service/Dockerfile -t e-commerce-backend-order-service-v2"
sh "Docker build -f product-service/Dockerfile -t e-commerce-backend-product-service-v2"
sh "Docker build -f service-registry/Dockerfile -t e-commerce-backend-service-registry-v2"

echo "Build completed. Please check images with cmd 'docker images'"