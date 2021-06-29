package Model;

public class fargadapter extends RecyclerView.Adapter<fargadapter.ItemViewHolder>{

    private final ArrayList<fragmodel> itemModelArrayList;


    public fargadapter(ArrayList<fragmodel>itemModelArrayList){
        this.itemModelArrayList = itemModelArrayList;
    }

    @NonNull
    @NotNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemViewHolder holder, int position) {
        fragmodel itemModel = itemModelArrayList.get(position);
        holder.title.setText(itemModel.getTitle());
        holder.description.setText(itemModel.getDescription());

        holder.deleteButton.setOnClickListener(v -> {

            itemModelArrayList.remove(position);

            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return itemModelArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageButton deleteButton;
        private final TextView title;
        private final TextView description;


        public ItemViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

            deleteButton = itemView.findViewById(R.id.list_item_delete_button);
        }
    }
}

}
