-- Cria index para acelerar a consulta no banco de dados -> O(1)
CREATE INDEX idx_review_user_product ON review (user_id, product_id);
