echo "Build script started"

sh "Docker build ./api-gateway/. -t e-commerce-backend-api-gateway-v2"
sh "Docker build ./authorization-service/. -t e-commerce-backend-authorization-service-v2"
sh "Docker build ./inventory-service/. -t e-commerce-backend-inventory-service-v2"
sh "Docker build ./order-service/. -t e-commerce-backend-order-service-v2"
sh "Docker build ./product-service/. -t e-commerce-backend-product-service-v2"
sh "Docker build ./service-registry/. -t e-commerce-backend-service-registry-v2"

echo "Build completed. Please check images with cmd 'docker images'"