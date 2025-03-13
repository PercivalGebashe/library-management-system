CREATE TRIGGER trigger_update_updated_at
    BEFORE UPDATE ON organizations
    FOR EACH ROW
EXECUTE FUNCTION update_updated_at_column();