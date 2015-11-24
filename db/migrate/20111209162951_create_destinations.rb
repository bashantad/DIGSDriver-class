class CreateDestinations < ActiveRecord::Migration
  def change
    create_table :destinations do |t|
      t.string :place
      t.text :description

      t.timestamps
    end
  end
end
